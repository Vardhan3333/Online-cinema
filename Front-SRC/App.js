import './App.css';
import Admin from './components/admin';
import Addtheatredetails from './components/addtheatredetails';
import Theatreslist from './components/theatreslist';
import User from './components/User';
import Login from './components/login';
import RegistrationPage from './components/RegistrationPage';
import MovieList from './components/MovieList'; 
import UserTheatres from './components/UserTheatres';
import Homepage from './components/HomePage';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Outlet // Add Outlet to handle nested routes
} from 'react-router-dom';
import Addshowdetails from './components/Addshowdetails';
import Demo from './components/demo';
import UserShows from './components/UserShows';
import ShowsList from './components/ShowsList';
import EditShow from './components/EditShow';
import AddMovieDetails from './components/AddMovieDetails';
import Theater from './components/Theatre';
import Payment from './components/Payment';
import EditTheatre from './components/EditTheatre';
import EditMovie from './components/EditMovie';
import Ticket from './components/Ticket';
import Confirmation from './components/Confirmation';
import UserDetails from './components/UserDetails';
import UserMovie from './components/UserMovie';

function App() {
  return (
    <div>
      <Router>
        <div>
          <Routes>
            <Route path="login" element={<Login />} />
            <Route path="admin" element={<Admin />} />
            <Route path="user" element={<User />} />
            <Route path="addtheatre" element={<Addtheatredetails />} />
            <Route path="addshow" element={<Addshowdetails />} />
            <Route path="theatres" element={<Theatreslist />} />
            <Route path="Register" element={<RegistrationPage />} />
            <Route path="demo" element={<Demo />} />
            <Route path="movielist" element={<MovieList />} />
            <Route path="usermovie/usertheatres" element={<UserTheatres />} />
            <Route path="usermovie/usertheatres/shows" element={<UserShows />} />
            <Route path="showsdetails" element={<ShowsList />} />
            <Route path="moviedetails" element={<MovieList />} />
            <Route path="editshow" element={<EditShow />} />
            <Route path="edittheatre" element={<EditTheatre />} />
              <Route path="editmovie" element={<EditMovie />} />  
            <Route path="addmovie" element={<AddMovieDetails />} />
            <Route path="theatre" element={<Theater />} />
            <Route path="theatre/payment" element={<Payment />} />
            <Route path="theatre/payment/confirm" element={<Confirmation />} />
            <Route path="theatre/payment/confirm/ticket" element={<Ticket />} />
            <Route path="ticket" element={<Ticket />} />
            <Route path="userdetails" element={<UserDetails />} />
            <Route path="usermovie" element={<UserMovie />} />
            <Route path="/" element={<Homepage />} />
            
          </Routes>
        </div>
      </Router>
    </div>
  );
}

export default App;
