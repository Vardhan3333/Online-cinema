import axios from "axios";

const ADMIN_API_BASE_URL= "http://localhost:8081/admin/"
const USER_API_BASE_URL= "http://localhost:8082/user/"

class Service1 {
    getHi(){
        return axios.get(`${USER_API_BASE_URL}Hi`);
    }

    addTheatre(data) {
        return axios.post(`${ADMIN_API_BASE_URL}addtheatre`, data);
    }

    addMovie(data) {
        return axios.post(`${ADMIN_API_BASE_URL}addmovie`, data);
    }

    addShow(data) {
        return axios.post(`${ADMIN_API_BASE_URL}addshow`, data);
    }

    editShow(data) {
        return axios.put(`${ADMIN_API_BASE_URL}editshow`, data);
    }

    editTheatre(data) {
        return axios.put(`${ADMIN_API_BASE_URL}edittheatre`, data);
    }

    editMovie(data) {
        return axios.put(`${ADMIN_API_BASE_URL}editmovie`, data);
    }

    getTheatres() {
        return axios.get(`${ADMIN_API_BASE_URL}theatrelist`);
    }

    getShowsData(){
        return axios.get(`${ADMIN_API_BASE_URL}shows`);
    }


    getCredentials(data){
        return axios.post(`${USER_API_BASE_URL}credentials`,data);
    }

    addUser(data){
        return axios.post(`${USER_API_BASE_URL}register`,data);
    }

    setLocation(formData){
        return axios.post(`${ADMIN_API_BASE_URL}movies`,formData);
    }

    getMovies(){
        return axios.get(`${ADMIN_API_BASE_URL}movieslist`);
    }

    getUserTheatres(){
        return axios.get(`${ADMIN_API_BASE_URL}usertheatreslist`);
    }

    sendshowID(formData){
        return axios.post(`${ADMIN_API_BASE_URL}showId`,formData);
    }

    sendMovieId(formData){
        return axios.post(`${ADMIN_API_BASE_URL}movieId`,formData);
    }
    

    sendTheatreId(formData){
        return axios.post(`${ADMIN_API_BASE_URL}theatreId`,formData);
    }

    getShowData(){
        return axios.get(`${ADMIN_API_BASE_URL}show`);
    }

    getUserShowList(){
        return axios.get(`${ADMIN_API_BASE_URL}usershowlist`);
    }

    sendBookingData(formData){
        return axios.post(`${ADMIN_API_BASE_URL}bookingdetails`,formData);
    }

    sendSeatDetails(selectedSeats){
        return axios.post(`${ADMIN_API_BASE_URL}seatdetails`,selectedSeats);
    }

    sendResult(formData){
        return axios.post(`${USER_API_BASE_URL}booking`,formData);
    }

    deleteMovie(formData){
        return axios.delete(`${ADMIN_API_BASE_URL}deletemovie`,formData);
    }
    deleteShow(formData){
        return axios.delete(`${ADMIN_API_BASE_URL}deleteshow`,formData);
    }

    deleteTheatre(formData){
        return axios.delete(`${ADMIN_API_BASE_URL}deletetheatre`,formData);
    }

}
const serviceInstance = new Service1(); 
export default serviceInstance