const Comment = ({comm}) => {
    return (
        <div className="comment-card">
            <div className={"comment-product"}>{comm.product}</div>
            <div>{comm.comment}</div>
        </div>
    )
}
export default Comment;