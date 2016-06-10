Activity Recognition
---------------------

## Link
- https://www.youtube.com/watch?v=S8sugXgUVEI&index=5&list=PLOU2XLYxmsIJDPXCTt5TLDu67271PruEk
- https://developers.google.com/android/reference/com/google/android/gms/location/ActivityRecognition

## Description

There are over a billion Android devices in the world, and they’re packed with sensors. Android Activity Recognition fuses this sensor data together to provide a simple, low-power interface for apps to understand what users are doing. 

## Notes
- API allows us to identify if User is
	- running
	- inside a vehicle
	- walking
	- biking

- Provides a battery efficient solution

- Machine learning model is used in background and provides a result that with 75% onfidence user is running
Data is provided by sensors.

- We can build applications on top of this API like

	- When user stops the car and starts walking, saves the parking location
	- e.g. Google Fit 
