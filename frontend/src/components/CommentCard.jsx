const CommentCard = ({comm, ticket}) => {
    return (
        <div className="comment-card">
            <div className={"comment-product"}>{comm.product}</div>
            <div>{comm.comment}</div>
            {ticket && <a href={`/ticket/${ticket.ticketId}`}>Go To Ticket</a>}
        </div>
    )
}
export default CommentCard;