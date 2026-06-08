import {useEffect, useState} from "react";
import CommentCard from "../components/CommentCard.jsx";

const Comments = () => {
    const [comments, setComments] = useState([]);
    const [tickets, setTickets] = useState([]);

    useEffect(() => {
        const getAllComments = async () => {
            try {
                const res = await fetch("http://localhost:8080/comments");
                const data = await res.json();
                setComments(data.comments);
                setTickets(data.tickets);
            } catch (err) {
                console.log(err);
            }
        }
        getAllComments();
    }, []);

    return (
        <div>
            <h1>Comments:</h1>
            <div className={"comment-grid"}>{comments.map((comment) => (
                <CommentCard
                    key={comment.commentId}
                    comm={comment}
                    ticket={tickets.find((t) => t.comment?.commentId === comment.commentId)}
                />
            ))}</div>
        </div>)
}


export default Comments