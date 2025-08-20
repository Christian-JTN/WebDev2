# 🚗 Car Management System

A modern Spring Boot web application for managing car inventory with CSV-based data persistence.

## Features

- **Car Information Management**: Store and manage detailed car information
- **Auto-incrementing Car IDs**: Automatic ID generation for each car
- **CSV Data Persistence**: All data is stored in a CSV file for easy backup and portability
- **Modern Web Interface**: Beautiful, responsive UI built with Thymeleaf and CSS
- **Form Validation**: Client-side and server-side validation for data integrity
- **Mobile Responsive**: Works perfectly on desktop, tablet, and mobile devices

## Car Attributes

Each car record includes the following information:

- **CarID**: Auto-incrementing unique identifier
- **License Plate Number**: Vehicle registration number
- **Make**: Car manufacturer (e.g., Toyota, Ford, Honda)
- **Model**: Car model name (e.g., Corolla, Mustang, Civic)
- **Year**: Manufacturing year (1900-2030)
- **Color**: Vehicle color
- **Body Type**: Sedan, SUV, or Hatchback
- **Engine Type**: Gasoline, Diesel, Electric, or Hybrid
- **Transmission**: Automatic or Manual

## Technology Stack

- **Backend**: Spring Boot 3.5.4
- **Frontend**: Thymeleaf templates with modern CSS
- **Data Storage**: CSV file (`cars.csv`)
- **Java Version**: 24
- **Build Tool**: Maven

## Getting Started

### Prerequisites

- Java 24 or higher
- Maven 3.6 or higher

### Installation

1. **Clone or download the project**
   ```bash
   git clone <repository-url>
   cd car
   ```

2. **Build the application**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

   Or alternatively:
   ```bash
   java -jar target/car-0.0.1-SNAPSHOT.jar
   ```

4. **Access the application**
   Open your web browser and navigate to: `http://localhost:8080`

## Usage

### Viewing Cars
- Navigate to the main page to see all cars in a table format
- Cars are displayed with color-coded badges for body type, engine type, and transmission
- The table is responsive and works on all device sizes

### Adding a New Car
1. Click the "Add New Car" button
2. Fill in all required fields in the form
3. Select appropriate options for Body Type, Engine Type, and Transmission
4. Click "Save Car" to add the car to your inventory
5. You'll be redirected back to the car list

### Managing Data
- **Clear All Cars**: Use the "Clear All Cars" button to remove all car records
- **CSV Export**: The `cars.csv` file in the project root contains all car data
- **Backup**: Simply copy the `cars.csv` file to backup your data

## File Structure

```
src/
├── main/
│   ├── java/com/jek/car/
│   │   ├── CarApplication.java          # Main Spring Boot application
│   │   ├── controller/
│   │   │   ├── CarController.java       # Handles car-related web requests
│   │   │   └── HomeController.java      # Handles root URL redirects
│   │   ├── model/
│   │   │   └── Car.java                 # Car entity with all attributes
│   │   └── service/
│   │       └── CarService.java          # Business logic and CSV operations
│   └── resources/
│       ├── application.properties       # Application configuration
│       └── templates/cars/
│           ├── list.html                # Car list page template
│           └── add.html                 # Add car form template
├── pom.xml                              # Maven dependencies and build config
└── cars.csv                             # Data storage file (created automatically)
```

## Data Storage

The application uses a CSV file (`cars.csv`) for data persistence with the following format:

```csv
CarID,LicensePlateNumber,Make,Model,Year,Color,BodyType,EngineType,Transmission
1,ABC123,Toyota,Corolla,2021,Blue,SEDAN,GASOLINE,AUTOMATIC
2,XYZ789,Ford,Mustang,2022,Red,SEDAN,GASOLINE,MANUAL
```

## Configuration

The application can be configured through `src/main/resources/application.properties`:

- `server.port`: Web server port (default: 8080)
- `spring.thymeleaf.cache`: Template caching (disabled for development)
- `logging.level.com.jek.car`: Logging level for the application

## Development

### Adding New Features
1. The modular structure makes it easy to extend functionality
2. Add new car attributes in the `Car.java` model
3. Update the `CarService.java` for CSV handling
4. Modify templates for UI changes

### Customization
- Modify CSS styles in the HTML templates for visual changes
- Add new validation rules in the form templates
- Extend the service layer for additional business logic

## Troubleshooting

### Common Issues

1. **Port already in use**
   - Change the port in `application.properties`: `server.port=8081`

2. **CSV file not found**
   - The file is created automatically on first run
   - Check file permissions in the project directory

3. **Form validation errors**
   - Ensure all required fields are filled
   - Check that year is between 1900 and current year + 1

### Logs
- Application logs are displayed in the console
- Set `logging.level.com.jek.car=DEBUG` for detailed logging

## License

This project is open source and available under the MIT License.

## Contributing

Feel free to submit issues, feature requests, or pull requests to improve the application.
