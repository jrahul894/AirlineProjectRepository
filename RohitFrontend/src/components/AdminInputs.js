import React from "react";

const AdminInputs = (props) => {
  const { label, onChange, id, ...inputprops } = props;

  return (
    <div className="AdminInput">
      <label style={{ fontSize: "1.5vw" }}>{label}</label>
      <input {...inputprops} onChange={onChange} />
    </div>
  );
};

export default AdminInputs;
