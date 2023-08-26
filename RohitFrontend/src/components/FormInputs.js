import React from "react";
import "./FormInputs.css";
const FormInputs = (props) => {
  const { label, onChange, id, ...inputprops } = props;

  return (
    <div className="FormInput">
      <label style={{ fontSize: "1.5vw" }}>{label}</label>
      <input {...inputprops} onChange={onChange} />
    </div>
  );
};

export default FormInputs;
