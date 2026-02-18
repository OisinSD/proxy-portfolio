# User Stories

This document defines the Proxy-Portfolio from the perspective of different viewers **Recruiters**, **Visitors** and **Admin**.

-------------

## Epic: User Experience (Frontend)

### Professional Profile
**As a** Recruiter, **I want** to see a clear summary of the developer's experience and skills, **So that** I can quickly evaluate their fit for a technical role.

**Acceptance Criteria**
* [ ]The "About" section is clearly accessible from the naviagation bar.
* [ ]The layout is responsive for mobile, tablet, and desktop views.
* [ ]Experience is ordered chronologically by date. 

### Project Portfolio
**As a** Recruiter/visitor, **I want** to browse a list of projects with clear descriptions and tech tags, **So that** I can choose which demo I want to interact with.

**Acceptance Criteria**
* [ ]Each project card displays a title, description, and tech stack.
* [ ]Data is retrieved via a REST API from the Java backend.

## Epic: PRoxy & Analytics (Backend)

### Embedded Project Demo
**As a** Recruiter/Visitor, **I want** to view and test a project demo within the portfolio site, **So that** I don't have to  manage multiple tabs or leave the current domain.

**Acceptance Criteria** 
* [ ]The Java server acts as a reverse proxy to fetch external content.
* [ ]The demo  renders within an 'iframe' or a react component.
* [ ]The URL in the browser remains on the portfolio domain.

### Engagement Tracking
**As a** System Admin, **I want** to log every time a project demo is launched, **So that** I can track  which projects are most interesting to viewers.

**Acceptance Criteria** 
* [ ]The System captures Project ID and timestamp on every launch.
* [ ]Data is persisted in a PostgreSQL database.
* [ ]The logging happens server-side to ensure accuracy.

## Epic: Insights

### Popularity Ranking
**As a** System Admin, **I want** to retrieve a list of projects ranked by their total view count, **So that** I can feature the most popular projecs at the top of the gallery.

**Acceptance Criteria** 
* [ ]The backend provides an endpoint to calculate the top Projects
* [ ]Calculations are performed using a SQL 'GROUP BY' and 'COUNT' query.