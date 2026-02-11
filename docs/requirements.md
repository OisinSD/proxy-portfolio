Functional Requiments 
    Overview
        FR-001: The System must allow a user to view portfolio without logging in.
        FR-002: The system must log every project view with a timestamp to the PostgreSQL database.
        FR-003: The Java server must intercept request to a Project and serve the content within the portfolio frame.

    Portfolio Frontend (React)  
        FR-001: The system must display a responsive landing page with sections for "About me", "Experience", and "Projects".  
        FR-002: The "Projects" section must fetch the list of available projects dynamically from the java backend (not hardcoded).
        FR-003: Users mist be able to click a "Lanuch Demo" button which opens the project within the current window (modal or embedded route) without navigating away from the portfolio domain.
    Proxy Backend (Java)
        FR-004: The backend must expose a generic proxy endpoint (e.g. /api/proxy/{projectId}) that accepts requests front the frontend.
        FR-005: Upon receiving a request, the backend must retrieve the target URL associated with the projectId from the database.
        FR-006: The backend must forward the request to the target URL, retrieve the response (HTML, JSON, etc.), and returnn it to the frontend.
        FR-007: Path Rewriting, The proxy must handle relatice links (CSS/JS imports) from the target project so they do not break when rendered on the portfolio domain.
    Analystics & Database
        FR-008: The system must verify if a project exists before attemption to proxy traffic. 
        FR-009: Event logic: Every successful proxy request must trigger a database write to the analystics table containing:
            ID, ProjectId (identify which project a viewer clicked on), Timestamp. 
        FR-010: The system must provide a secured API endpoint (api/admin/stats) that returns aggregated view counts for owner (myself). 


Non-Functional Requirements
    Security
        NFR-001: The System must strictly adhere to target URLs provided. The proxy must refuse to foward requests to unrelated URLs provided by the users input(I.g. stopping users from asking the proxy to fetch localhost:8080 or any internal files).
        NFR-002: Backend must be configured to only accept API calls from the React frontend domain.
        
    Performance
        NFR-003: Concurrency: The database must support simultanceous writes if mltiple users view projects at the same time.
        NFR-004: Failure Handling: If the project is down or times out, the system must return a custom "503 Service Unavailable" error page to the React frontend, rahter than crashing or showing a raw stack trace. 
        