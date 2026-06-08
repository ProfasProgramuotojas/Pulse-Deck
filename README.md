# PulseDeck

A full-stack comment-to-ticket triage app: users submit product feedback, and a Hugging Face language model decides whether each comment should become a support ticket.

## Description

PulseDeck collects user comments about a product and uses AI to triage them. Each submitted comment is sent to a Hugging Face language model, which decides whether the comment is actionable enough to create a support ticket. If it is, the model returns structured ticket data.

The backend is a RESTful Spring Boot service backed by an in-memory H2 database; the frontend is a React (Vite) app for submitting comments and browsing the resulting comments and tickets.

## Getting Started

### Dependencies

- JDK 25
- Node.js 18+ and npm (for the frontend)
- A Hugging Face access token with Inference Providers enabled

### Installing

1. Clone the repository:

```
git clone git@github.com:ProfasProgramuotojas/Pulse-Deck.git
cd Pulse-Deck
```

2. Set your Hugging Face token.

The backend reads the token from the `HF_TOKEN` environment variable (referenced in `application.properties` as `huggingface.api.token=${HF_TOKEN}`). Set it in the **same terminal session** you'll use to run the backend - by default the variable only lives for that session.

**Linux / macOS (bash, zsh):**
```bash
export HF_TOKEN=hf_your_token_here
```

**Windows - Command Prompt (cmd):**
```bat
set HF_TOKEN=hf_your_token_here
```

**Windows - PowerShell:**
```powershell
$env:HF_TOKEN = "hf_your_token_here"
```

No other file modifications are required for local development.

### Executing program

The backend and frontend run as two separate dev servers.

1. Start the backend from the project root (the API serves on `http://localhost:8080`). Make sure `HF_TOKEN` is set in this terminal first (see above), then run the Maven wrapper for your shell:

**Linux / macOS:**
```bash
./mvnw spring-boot:run
```

**Windows - Command Prompt (cmd):**
```bat
mvnw.cmd spring-boot:run
```

**Windows - PowerShell:**
```powershell
.\mvnw.cmd spring-boot:run
```

2. In a second terminal, start the frontend from the `frontend/` directory (the UI serves on `http://localhost:5173`). Same on every platform:

```
cd frontend
npm install
npm run dev
```

3. Open `http://localhost:5173` in a browser, submit a comment, and watch tickets appear for actionable feedback.

## API Reference

Four endpoints. The naming convention: a **singular** path operates on a single resource, a **plural** path returns a list.

- `POST /comment` - creates a comment, runs AI analysis, and conditionally creates a linked ticket. Request body: `{ "product": String, "comment": String }`. Returns the comment analysis. 
- `GET /comments` - returns all comments together with all tickets, so the client can link each comment to its ticket if one exists.
- `GET /tickets` - returns the full list of tickets for the overview page.
- `GET /ticket/{ticketId}` - returns a single ticket by id, including its summary and linked comment. Returns `404 Not Found` if the id does not exist.

## Notes on design decisions

1. **Model choice (deviation from the brief).** The exercise suggested `google/flan-t5-base`, `mistralai/Mistral-7B-Instruct`, and `tiiuae/falcon-7b-instruct`. As of building this project, none of these are deployed by any Hugging Face Inference Provider - their model pages show "This model isn't deployed by any Inference Provider,". The brief explicitly allows any other Hugging Face model that fits the task, so I used `meta-llama/Llama-3.1-8B-Instruct`, served through Hugging Face's OpenAI-compatible router endpoint (`https://router.huggingface.co/v1/chat/completions`). That endpoint also supports a `response_format: json_object` constraint, which makes the structured triage output more reliable.

2. **Endpoint naming (deviation from the brief).** The brief suggested `POST /comments`, `GET /comments`, `GET /tickets`, `GET /tickets/{ticketId}`. I kept collection routes plural but used singular paths for single-resource operations (`POST /comment`, `GET /ticket/{ticketId}`), which I found more consistent to reason about.

## Authors

Mykolas - GitHub [@ProfasProgramuotojas](https://github.com/ProfasProgramuotojas)
