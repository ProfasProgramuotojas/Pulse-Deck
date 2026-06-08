import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import CommentCard from "../components/CommentCard.jsx";


const Ticket = () => {
    const [ticket, setTicket] = useState(null);
    const {ticketId} = useParams();

    useEffect(() => {
        const getTicket = async () => {
            try {
                const res = await fetch(`http://localhost:8080/ticket/${ticketId}`);
                const data = await res.json();
                setTicket(data);
            } catch (err) {
                console.log(err);
            }
        }
        if (ticketId) getTicket();
    }, [ticketId]);

    if(!ticket) return null;
    return (
        <div className={"ticket-page"}>
            <div>
            <h1>Ticket</h1>
            <h2>Title: {ticket.title}</h2>
            <div>Priority: {ticket.priority}</div>
            <div>Category: {ticket.category}</div>
                <p>Summary: {ticket.summary}</p>
            </div>
            <div>
                <h1>Comment</h1>
                <CommentCard comm={ticket.comment} />
            </div>
        </div>
    )
}

export default Ticket;