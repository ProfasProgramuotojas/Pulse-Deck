const TicketCard = ({ticket}) => {
    if(!ticket) return null;
    return (
        <div className="ticket-card" onClick={() => document.location.href = `/ticket/${ticket.ticketId}`}>
            <h3>Title: {ticket.title}</h3>
            <div>Priority: {ticket.priority}</div>
            <div>Category: {ticket.category}</div>
        </div>
    )
}
export default TicketCard;