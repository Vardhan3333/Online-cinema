import React, { useState } from 'react';
import './style.css'; // Import your CSS file
import Service1 from '../service/service1';
import { Link } from 'react-router-dom';

function TheaterLayout() {
  const [levels, setLevels] = useState(3); // Number of levels
  const [rowsPerLevel, setRowsPerLevel] = useState([5, 6, 7]); // Rows in each level (an array)
  const [seatsPerRow, setSeatsPerRow] = useState([8, 8, 8]); // Seats in each row (an array)
  const [selectedSeats, setSelectedSeats] = useState([]); // Array to store selected seats

  const sendSelectedSeatsToBackend = () => {
    // Prepare the data to send to the backend
    console.log('Selected Seats:');
    // // selectedSeats.forEach((seat) => {
    // //     console.log(seat);
    // // });
    // console.log(selectedSeats);
    // const data = {
    //   selectedSeats,}
    // const data = {
        // selectedSeats: selectedSeats,
    //   };
    //   const formData = new FormData();
    //   formData.append('selectedseats',selectedSeats)
    // console.log(data);
    Service1.sendSeatDetails(selectedSeats).then((response)=> {
        console.log('Selected Seats sent to the backend:', response.data);
      })
      .catch((error) => {
        console.error('Error sending selected seats:', error);
      });
    };
  // Function to handle seat selection
  const handleSeatClick = (levelIndex, rowIndex, seatIndex) => {
    // Create a unique seat identifier with row alphabet and seat number
    const seatIdentifier = `${String.fromCharCode(65 + rowIndex)}-${seatIndex + 1}-Level ${levelIndex + 1}`;

    // Check if the seat is already selected
    if (selectedSeats.includes(seatIdentifier)) {
      // If selected, remove it from the selected seats
      setSelectedSeats((prevSelectedSeats) =>
        prevSelectedSeats.filter((seat) => seat !== seatIdentifier)
      );
    } else {
      // If not selected, add it to the selected seats
      setSelectedSeats((prevSelectedSeats) => [...prevSelectedSeats, seatIdentifier]);
    }
  };

  // Function to display selected seats in the console
//   const printSelectedSeats = () => {
//     console.log('Selected Seats:');
//     selectedSeats.forEach((seat) => {
//       console.log(seat);
//     });
//   };

  return (
    <div className="theater-container">
      <div className="theater">
        {Array.from({ length: levels }, (_, levelIndex) => (
          <div key={levelIndex} className="section">
            <h2>Level {levelIndex + 1}</h2>
            {Array.from({ length: rowsPerLevel[levelIndex] }, (_, rowIndex) => (
              <div key={rowIndex} className="level">
                <div className="row">
                  <div className="row-name">{String.fromCharCode(65 + rowIndex)}</div>
                  {Array.from({ length: seatsPerRow[levelIndex] }, (_, seatIndex) => (
                    <div
                      key={seatIndex}
                      className={`seat ${selectedSeats.includes(
                        `${String.fromCharCode(65 + rowIndex)}-${seatIndex + 1}-Level ${levelIndex + 1}`
                      ) ? 'selected' : ''}`}
                      onClick={() => handleSeatClick(levelIndex, rowIndex, seatIndex)}
                    >
                      {seatIndex + 1}
                    </div>
                  ))}
                </div>
              </div>
            ))}
          </div>
        ))}
      </div>
      <Link to="payment">
      <button onClick={sendSelectedSeatsToBackend}>Print Selected Seats</button></Link>
    </div>
  );
}

export default TheaterLayout;
