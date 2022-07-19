import logo from './logo.svg';
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route,Routes,Link } from "react-router-dom";
import Login from './components/Login';
import Register from './components/Register';
function App() {
  return (
    <Router>
      <nav>
      </nav>
      <Routes>
      <Route path="/login" element={<Login/>} />
      <Route path="/register" element={<Register/>} />
      </Routes>
    </Router>
  );
}

export default App;
