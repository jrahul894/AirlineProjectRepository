import React from "react";

const Footer = () => {
  const year = new Date().getFullYear();

  return (
    <footer id="footer" style={{ backgroundColor: "grey", width: "100%" }}>
      <p class="contact-info">
        Copyright © HorizonSky Booking Services <span class="year"></span>
        <span class="phone">
          <a href="/">+912084422881</a>
        </span>
        <span class="email">
          <a href="mailto:fasir20379@gmail.com">fasir20379@gmail.com</a>
        </span>
      </p>
    </footer>
  );
};

export default Footer;
