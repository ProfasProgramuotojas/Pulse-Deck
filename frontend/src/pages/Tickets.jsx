import {useEffect, useState} from "react";
import TicketCard from "../components/TicketCard.jsx";

const Tickets = () => {
    const [tickets, setTickets] = useState([]);

    useEffect(() => {
        const getAllTickets = async () => {
            try {
                const res = await fetch("http://localhost:8080/tickets");
                const data = await res.json();
                setTickets(data);
            } catch (err) {
                console.log(err);
            }
        }
        getAllTickets();
    }, []);

    return (
        <div>
            <h1>Tickets:</h1>
            <div className={"ticket-grid"}>{tickets.map((ticket) => (
                <TicketCard
                    key={ticket.ticketId}
                    ticket={ticket}
                />
            ))}</div>
        </div>)
}


export default Tickets