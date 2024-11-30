
# **Spatial Data Analysis with PostgreSQL, H2GIS, and Kotlin**

## **Project Overview**
This project is a spatial data analysis tool that integrates PostgreSQL for data storage and retrieval, H2GIS for spatial data manipulation, and Kotlin for application development. The tool processes shop data near tram stops in Moscow, performs transformations, and outputs analytical insights.

---

## **Project Structure**

### **Part 1: Data Preparation**
#### **Tasks:**
1. **Setup PostgreSQL Database:**
   - Installed PostgreSQL and created the database `moscow_data`.
   - Imported GIS shapefiles into the database (`poi-point`, `railway-station-point`, etc.).
   - Ensured proper indexing and spatial reference system compatibility using `PostGIS`.

2. **Spatial Queries:**
   - Verified the database using spatial queries to confirm that points and geometries loaded correctly.
   - Indexed geometries for optimized query performance using `GIST`.

---

### **Part 2: PostgreSQL Queries**
#### **Tasks:**
1. **Data Analysis Queries:**
   - Wrote and tested SQL queries to retrieve shops within a 200-meter radius of tram stations.
   - Used `ST_DWithin` and `ST_AsText` for spatial analysis and conversion to WKT format.
   - Exported results for transformation and further processing.

2. **Performance Optimization:**
   - Tuned queries for better performance using indexed geometries and query optimizations.

---

### **Part 3: Application Development**
#### **Tasks:**
1. **Setup Development Environment:**
   - Configured Kotlin and Gradle for application development.
   - Installed necessary dependencies, including:
     - PostgreSQL JDBC Driver
     - H2GIS for spatial analysis
     - SLF4J for logging

2. **Application Code:**
   - Implemented the following functions:
     - `getPostgresConnection()`: Connects to PostgreSQL.
     - `fetchShopsData()`: Fetches shop data near tram stops in WKT format.
     - `getH2GISConnection()`: Creates an in-memory H2GIS database and loads H2GIS functions.
     - `importDataToH2GIS()`: Imports the fetched PostgreSQL data into the H2GIS database.
     - `analyzeShopsAccessibility()`: Analyzes shop data and outputs the number of accessible shops by type.

3. **Debugging and Configuration:**
   - Addressed dependency conflicts and ensured compatibility between H2GIS and the H2 driver.
   - Fixed errors with spatial functions and domain declarations.

4. **Output:**
   - Counted accessible shops by type and displayed the results.
---

## **Key Outputs**
The application outputs the count of accessible shops by type in descending order. For example:
```
Accessible shops by type:
convenience: 2181
supermarket: 1470
hairdresser: 808
clothes: 804
...
```

---

## **Key Dependencies**
- **PostGIS**: For spatial data storage and querying.
- **H2GIS**: For in-memory spatial database operations.
- **Kotlin**: Programming language for application logic.
- **Gradle**: Build automation system.

