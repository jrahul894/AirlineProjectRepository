import "./App.css";
import Header from "./components/Header";
import FormInputs from "./components/FormInputs";
import LoginInputs from "./components/LoginInputs";
import Footer from "./components/Footer";
import { useState } from "react";
import AdminInputs from "./components/AdminInputs";

const App = () => {
  const [values, setValues] = useState({
    Firstname: "",
    Lastname: "",
    Password: "",
    Email: "",
    Phone: "",
    Roll: "",
    DOB: "",
  });
  const [adminvalues, setadminvalues] = useState({
    adminName: "",
    adminPassword: "",
  });

  const [loginvalues, setloginvalues] = useState({
    Firstname2: "",
    Password2: "",
  });
  const admininputs = [
    {
      id: 1,
      name: "adminName",
      type: "text",
      placeholder: "Name",
      label: "Name",
    },
    {
      id: 2,
      name: "adminPassword",
      type: "text",
      placeholder: "Password",
      label: "password",
    },
  ];
  const logininputs = [
    {
      id: 1,
      name: "FirstName2",
      type: "text",
      placeholder: "Name",
      label: "Name",
    },
    {
      id: 2,
      name: "Password2",
      type: "text",
      placeholder: "Password",
      label: "Password",
    },
  ];
  const inputs = [
    {
      id: 1,
      name: "FirstName",
      type: "text",
      placeholder: "FirstName",
      label: "FirstName",
    },
    {
      id: 2,
      name: "LastName",
      type: "text",
      placeholder: "LastName",
      label: "LastName",
    },
    {
      id: 3,
      name: "Password",
      type: "text",
      placeholder: "Password",
      label: "Password",
    },
    {
      id: 4,
      name: "Email",
      type: "text",
      placeholder: "Email",
      label: "Email",
    },
    {
      id: 5,
      name: "DOB",
      type: "text",
      placeholder: "DOB",
      label: "DOB",
    },
    {
      id: 6,
      name: "Mobile_No",
      type: "text",
      placeholder: "Mobile_No",
      label: "Mobile_No",
    },
  ];

  const handleSubmitLogin = (e) => {
    e.preventDefault();
    console.log(loginvalues);
  };
  const handleAdminLogin = (e) => {
    e.preventDefault();
    console.log(adminvalues);
  };
  const handleSubmitRegistration = (e) => {
    e.preventDefault();
    console.log(values);
  };
  const onAdminChange = (e) => {
    setadminvalues({ ...adminvalues, [e.target.name]: e.target.value });
  };
  const onChange = (e) => {
    setValues({ ...values, [e.target.name]: e.target.value });
  };
  const onLoginChange = (e) => {
    setloginvalues({ ...loginvalues, [e.target.name]: e.target.value });
  };

  return (
    <div className="App">
      <Header />
      <br />
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <table style={{ border: "1px solid black", width: "100%" }}>
        <tr>
          <td>
            <div className="form-container">
              <h1
                style={{
                  fontSize: "1.5vw",
                  marginLeft: "45%",
                  paddingBottom: "2%",
                }}
              >
                Login Form
              </h1>
              <form id="form1" onSubmit={handleSubmitLogin}>
                {logininputs.map((input) => (
                  <LoginInputs
                    key={input.id}
                    {...input}
                    value={values[input.name]}
                    onChange={onLoginChange}
                  />
                ))}
                <button style={{ fontSize: "1.5vw" }} type="submit">
                  Submit
                </button>
              </form>
            </div>
          </td>
          <td>
            <div className="form-container">
              <h1
                style={{
                  marginTop: "20%",
                  fontSize: "1.5vw",
                  marginLeft: "45%",
                  paddingBottom: "2%",
                }}
              >
                Registration form
              </h1>
              <form id="form2" onSubmit={handleSubmitRegistration}>
                {inputs.map((input) => (
                  <FormInputs
                    key={input.id}
                    {...input}
                    value={values[input.name]}
                    onChange={onChange}
                  />
                ))}
                <button style={{ fontSize: "1.5vw" }} type="submit">
                  Submit
                </button>
              </form>
            </div>
          </td>
        </tr>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>

        <tr>
          <td>
            <h1
              style={{
                fontSize: "1.5vw",
                marginLeft: "60%",
                paddingBottom: "2%",
              }}
            >
              Admin Login Form
            </h1>
            <form
              id="form3"
              onSubmit={handleAdminLogin}
              style={{ marginLeft: "50%", width: "50%" }}
            >
              {admininputs.map((input) => (
                <AdminInputs
                  key={input.id}
                  {...input}
                  value={adminvalues[input.name]}
                  onChange={onAdminChange}
                />
              ))}
              <button style={{ fontSize: "1.5vw" }} type="submit">
                Submit
              </button>
            </form>
          </td>
        </tr>
      </table>
      <br></br>
      <br></br>
      <br></br>
      <br></br>

      <Footer />
    </div>
  );
};

export default App;
