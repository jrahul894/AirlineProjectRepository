import React from "react";
import Navbar from "./Navbar.js";
import logo from "./R.jpg";
import logo2 from "./R2.jpg";

function Header() {
  return (
    <div id="main">
      <Navbar />

      <div className="name">
        <table style={{ marginTop: "5%" }}>
          <tr>
            <td>
              <p
                className="details1"
                style={{
                  fontSize: "2vw",
                  float: "left",
                  paddingLeft: "5%",
                  paddingRight: "5%",
                  textAlign: "justify",
                }}
              >
                Book your perfect flight today with HorizonSky Booking Services.
                Choose from a wide range of flights on all major routes across
                India with premium Airlines.
              </p>
            </td>
            <td>
              <img
                src={logo}
                style={{
                  height: "40vh",
                  width: "28vw",
                  float: "right",
                  marginRight: "5%",
                }}
                alt="flight image 1"
              />
            </td>
          </tr>

          <tr style={{ paddingTop: "100%" }}>
            <td>
              <img
                src={logo2}
                style={{ height: "40vh", width: "28vw", marginLeft: "5%" }}
                alt="flight image 2"
              />
            </td>
            <td>
              <p
                className="details2"
                style={{
                  fontSize: "2vw",
                  marginLeft: "5%",
                  marginRight: "5%",
                  textAlign: "justify",
                }}
              >
                Embark on a journey of comfort and happiness as you explore the
                horizons with HorizonSky Booking Services. Our experienced team
                is committed to creating an exceptional travel experience for
                you. Discover seamless connections, impeccable service, and a
                wide variety of destinations waiting to be explored. Your dream
                flight awaits. Book now and travel with HorizonSky!
              </p>
            </td>
          </tr>
        </table>
      </div>
    </div>
  );
}

export default Header;
