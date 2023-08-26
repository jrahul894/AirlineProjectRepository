import React from "react";
import logo from "./_893.png";

function Navbar() {
  return (
    <nav className="nav-class">
      <label className="menu-icon" htmlFor="menu-btn">
        <span className="nav-icon"></span>
        <ul className="menu">
          <li>
            <a href="#form3">Admin Login</a>
          </li>

          <li>
            <a href="/">Home</a>
          </li>
          <li>
            <a href="#footer">About</a>
          </li>
          <li>
            <a href="#form2">Register</a>
          </li>
          <li>
            <a href="#footer">Contact us</a>
          </li>
          <li>
            <a href="#form1">Login</a>
          </li>
        </ul>
      </label>
      <img
        src={logo}
        style={{ height: "15%", width: "20%", float: "left" }}
        alt="airline flight"
      />
      <h1
        style={{
          textAlign: "center",
          color: "red",
          marginRight: "25%",
          marginLeft: "2%",
          fontSize: "2.5vw",
          marginTop: "10vh",
          marginBottom: "8vh",
        }}
      >
        HorizonSky Booking Services
      </h1>
      <br />
      <br />
      <br />

      <br />
      <br />
      <br />
      <span
        className="blink"
        style={{
          textAlign: "center",
          marginLeft: "10%",
          fontSize: "2.5vw",
        }}
      >
        Book your dream flight TODAY!
      </span>
    </nav>
  );
}

export default Navbar;
