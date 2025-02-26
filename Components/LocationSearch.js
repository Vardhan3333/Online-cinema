import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Select from 'react-select';
import Service1 from '../service/service1';


const locationOptions = [
  { label: 'Bangalore', value: 'Bangalore' },
  { label: 'Delhi', value: 'Delhi' },
  { label: 'Vizag', value: 'Vizag' },
  { label: 'Hyderabad', value: 'Hyderabad' },
  { label: 'Mumbai', value: 'Mumbai' },
  { label: 'Kolkata', value: 'Kolkata' },
  { label: 'Vishakapatnam', value: 'Vishakapatnam' }
  // Add more location options as needed
];

 export default class LocationSearch extends Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedOption: null,
      locationData: null, // Add a state to store fetched data
    };
  }

//   componentDidMount() {
//     // Fetch data from the backend when the component mounts
//     this.fetchLocationData();
//   }

  handleChange = (selectedOption) => {
    this.setState({ selectedOption });

    // Send the selected location to the backend
    if (selectedOption) {
      const selectedLocation = selectedOption.value;
    //   const data ={location: selectedLocation };
    //   console.log(data);
    // const location = selectedLocation;
    const formData = new FormData();
      formData.append('location', selectedLocation);

      Service1.setLocation(formData)
      .then((response) => {
          console.log('Location data sent to the backend:', response.data);
          console.log(selectedOption.value);
          // You can handle the response from the backend here
          // Fetch updated data after sending the location
          
          
        })
        .catch((error) => {
          console.error('Error sending location data to the backend:', error);
        });
        // this.props.history.push(`/movielist?location=${selectedLocation}`);
    }
  };

//   fetchLocationData() {
//     // Fetch data from the backend
//     axios.get('/api/your-backend-endpoint-for-data')
//       .then((response) => {
//         console.log('Fetched location data from the backend:', response.data);
//         this.setState({ locationData: response.data });
//       })
//       .catch((error) => {
//         console.error('Error fetching location data from the backend:', error);
//       });
//   }

  render() {
    const { selectedOption, locationData } = this.state;

    return (
      <div>
        <h3>Location Search</h3>
        <Select
          value={selectedOption}
          onChange={this.handleChange}
          options={locationOptions}
          isSearchable={true}
          placeholder="Search for a location..."
        />
        <Link to="/usermovie">
        <button onClick={this.handleSubmit}>Submit Location</button>
        </Link>
        
        {/* Display fetched data */}
        {locationData && (
          <div>
            <h4>Location Data:</h4>
            <pre>{JSON.stringify(locationData, null, 2)}</pre>
          </div>
        )}
      </div>
    );
  }
}
