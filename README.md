# Sinethemba Vilakazi's Enviro365 assessment

created  a user-friendly and informative application that empowers users to make environmentally conscious decisions. 
The application features various functionalities, including waste category lookup, disposal guidelines retrieval, and recycling
tips display.

## Table of Contents

1. [Installation](#installation)
2. .[Usage](#Usage)
3. [Endpoints](#endpoints)
4. [Testing](#testing)

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/sinethembaVilakazi/assessment.git
   ```
## Usage
1.**Build the Project:**
 ```bash
 mvn clean package
   ```
2.**Start the Application:**
 ```bash
 mvn spring-boot:run
   ```
3.**Access the API Endpoints:**
- Open your web browser or API testing tool such as Postman.
- Use the provided endpoints to interact with the application.

4.**Configure Environment:**
- Set up a compatible database (e.g., MySQL, PostgreSQL).
- Configure database connection properties in application.properties.

## Endpoints
endpoints for the `WasteCategory`, `DisposalGuidelines`, and `RecyclingTip` entities.

### WasteCategory Endpoints
1. **GET All Waste Categories**
   - Method: GET
   - Endpoint: `/api/waste-category`
   - Description: Get all waste categories.

2. **GET Waste Category by ID**
   - Method: GET
   - Endpoint: `/api/waste-category/{id}`
   - Description: Get a specific waste category by ID.

3. **GET Waste Category by Name**
   - Method: GET
   - Endpoint: `/api/waste-category/category/{categoryName}`
   - Description: Get a waste category by its name.

4. **CREATE Waste Category**
   - Method: POST
   - Endpoint: `/api/waste-category`
   - Description: Create a new waste category.
   - Request Body: JSON with `categoryName`, `biodegradable`, and `type` fields.

5. **UPDATE Waste Category**
   - Method: PUT
   - Endpoint: `/api/waste-category/{id}`
   - Description: Update an existing waste category by ID.
   - Request Body: JSON with updated `categoryName`, `biodegradable`, and `type` fields.

6. **DELETE Waste Category**
   - Method: DELETE
   - Endpoint: `/api/waste-category/{id}`
   - Description: Delete a waste category by ID.

### DisposalGuidelines Endpoints
1. **GET All Disposal Guidelines**
   - Method: GET
   - Endpoint: `/api/disposal-guidelines`
   - Description: Get all disposal guidelines.

2. **GET Disposal Guidelines by ID**
   - Method: GET
   - Endpoint: `/api/disposal-guidelines/{id}`
   - Description: Get a specific disposal guideline by ID.

3. **GET Disposal Guidelines by Category Name**
   - Method: GET
   - Endpoint: `/api/disposal-guidelines/category/{categoryName}`
   - Description: Get disposal guidelines by category name.

4. **CREATE Disposal Guideline**
   - Method: POST
   - Endpoint: `/api/disposal-guidelines`
   - Description: Create a new disposal guideline.
   - Request Body: JSON with `categoryName`, `hazardous`, and `disposalMethods` fields.

5. **UPDATE Disposal Guideline**
   - Method: PUT
   - Endpoint: `/api/disposal-guidelines/{id}`
   - Description: Update an existing disposal guideline by ID.
   - Request Body: JSON with updated `categoryName`, `hazardous`, and `disposalMethods` fields.

6. **DELETE Disposal Guideline**
   - Method: DELETE
   - Endpoint: `/api/disposal-guidelines/{id}`
   - Description: Delete a disposal guideline by ID.

### RecyclingTip Endpoints
1. **GET All Recycling Tips**
   - Method: GET
   - Endpoint: `/api/recycling-tips`
   - Description: Get all recycling tips.

2. **GET Recycling Tip by ID**
   - Method: GET
   - Endpoint: `/api/recycling-tips/{id}`
   - Description: Get a specific recycling tip by ID.

3. **CREATE Recycling Tip**
   - Method: POST
   - Endpoint: `/api/recycling-tips`
   - Description: Create a new recycling tip.
   - Request Body: JSON with `categoryName` and `tip` fields.

4. **UPDATE Recycling Tip**
   - Method: PUT
   - Endpoint: `/api/recycling-tips/{id}`
   - Description: Update an existing recycling tip by ID.
   - Request Body: JSON with updated `categoryName` and `tip` fields.

5. **DELETE Recycling Tip**
   - Method: DELETE
   - Endpoint: `/api/recycling-tips/{id}`
   - Description: Delete a recycling tip by ID.


## Testing
```bash
   mvn test
   ```

