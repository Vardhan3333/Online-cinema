
import React from "react";
import { Link } from "react-router-dom"; 
import './HomeStyle.css'

export default function Home() {
    return (
      <div className="home-container">
        <div className="background-image"></div>
        <div className="content">
          <h1 id="h1">Welcome to ONLINE CINEMA TICKETING SYSTEM</h1>
          <div className="button-container">
            
            <Link to="/login" className="button user-button" style={{ marginTop: "200px" }}>
              Login
            </Link>
          </div>
        </div>
      </div>
    );
  }
 