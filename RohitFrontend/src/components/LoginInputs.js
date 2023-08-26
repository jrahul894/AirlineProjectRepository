import React from "react";

const LoginInputs = (props) => {
  const { label, onChange, id, ...inputprops } = props;
  return (
    <div className="LoginInput">
      <label style={{ fontSize: "1.5vw" }}>{label}</label>
      <input {...inputprops} onChange={onChange} />
    </div>
  );
};

export default LoginInputs;
