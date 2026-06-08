import {BrowserRouter, Route, Routes} from "react-router-dom";
import Comments from "./pages/Comments.jsx";
import Home from "./pages/Home.jsx";
import "./App.css";
import Tickets from "./pages/Tickets.jsx";
import Ticket from "./pages/Ticket.jsx";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/comments" element={<Comments/>}/>
                <Route path="/tickets" element={<Tickets/>}/>
                <Route path="/ticket/:ticketId" element={<Ticket/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
