import {useRef, useState} from "react";

const preDefinedProducts = [
    "Cloud Storage",
    "Mobile App",
    "Billing Portal",
    "Developer API",
    "Analytics Dashboard",
    "Account & Login",
    "Other",
];

const preDefinedComments = [
    "Uploads keep failing halfway through with large files",
    "Sync between my laptop and phone is really slow",
    "Would love folder-level sharing permissions",
    "The app crashes every time I open the notifications tab",
    "Dark mode would be amazing",
    "I was charged twice for this month's subscription",
    "Can't download my invoice as a PDF",
    "Getting intermittent 500 errors on the /search endpoint",
    "Please add webhook support for ticket events",
    "Charts don't render at all on Safari",
    "An export-to-CSV button would save me hours",
    "I can't reset my password — the email never arrives",
    "Two-factor auth keeps logging me out randomly",
    "The backups have been rock solid, thank you!",
    "Smoothest mobile experience I've used in ages",
    "Login is so quick now with SSO",
];

const Home = () => {
    const [product, setProduct] = useState("");
    const [comment, setComment] = useState("");

    const formRef = useRef(null);

    const handleSubmit = async (e) => {
        e.preventDefault();
        const res = await fetch("http://localhost:8080/comment", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({product: product, comment: comment})
        });
        if (res) document.location.href = "/comments";
    }

    return (
        <div className={"home-page"}>
            <h1>Create Comment</h1>
            <form ref={formRef} onSubmit={handleSubmit}>
                <div>
                    <label> Product</label>
                    <select onChange={(e) => {
                        setProduct(e.target.value)
                    }}>
                        <option>Fill Product</option>
                        {preDefinedProducts.map((product) => (
                            <option key={product} value={product}>{product}</option>))}
                    </select>
                </div>

                <input value={product} onChange={(e) => setProduct(e.target.value)}/>
                <div>
                    <label> Comment</label>
                    <select onChange={(e) => {
                        setComment(e.target.value)
                    }}>
                        <option>Fill Comment</option>
                        {preDefinedComments.map((comment) => (
                            <option key={comment} value={comment}>{comment}</option>))}
                    </select>
                </div>
                <input value={comment} onChange={(e) => setComment(e.target.value)}/>
                <button type={"submit"}>Submit</button>
            </form>
            <a href={"/comments"}>All Comment</a>
            <a href={"/tickets"}>All Tickets</a>
        </div>)
}

export default Home