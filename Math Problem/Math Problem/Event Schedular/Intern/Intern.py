from asyncio import events
import datetime

# Initializing empty list to store events
events = []

# Function to display the menu options
def menu():
    print("Event Scheduler")
    print("1. Add event")
    print("2. Delete event")
    print("3. List events")
    print("4. Search event")
    print("5. Edit event")
    print("6. Exit")

# Main function to run the program
def main():
    while True:
        menu()
        
        choice = input("Enter your choice:  ")

        if choice =='1':
            
            title = input("Enter event title: ")
            description = input("Enter description of the event: ")
            date = input("Enter date (YYYY-MM-DD): ")
            time = input("Enter time (HH:MM): ")
            add_event(title, description, date, time)

        elif choice == '2':

            title = input("Enter title of the event you wish to delete: ")
            delete_event(title)

        elif choice == '3':

            list_events()

        elif choice == '4':
           
            title = input("Enter event you wish to search: ")
            search_event(title)

        elif choice == '5':

            edit_event()

        elif choice == '6':

            print("Thank you for using Event Scheduler")
            break

        else:
            print("Invalid choice. Please choose again!")


# Function to search for an event by title
def search_event(title):

    found_event = [event for event in events if event['title'].lower() == title.lower()]

    if found_event:
        print("Matching Events:")
        for event in found_event:
            print(f"Title: {event['title']}")
            print(f"Description: {event['description']}")
            print(f"Date: {event['date']}")
            print(f"Time: {event['time']}")
            print(f"-" * 20)
    else:
        print(f"No event with title '{title}' found.")

# Function to list all events
def list_events():

    if not events:

        print("No events found")
        return

    sort_events = sorted(events, key=lambda x: (x['date'], x['time']))

    for event in sort_events:
        print(f"Title: {event['title']}")
        print(f"Description {event['description']}")
        print(f"Date: {event['date']}")
        print(f"Time: {event['time']}")
        print("-" * 20)

# Function to add a new event
def add_event(title, description, date, time):

    while True:
        try:
            # Validate date format
            year, month, day = map(int, date.split('-'))
            datetime.datetime(year=year, month=month, day=day)

            # Validate time format
            hours, minutes = map(int, time.split(':'))
            if hours < 0 or hours > 23 or minutes < 0 or minutes > 59:
                raise ValueError

            # Add event to the list
            events.append({
                'title': title,
                'description': description,
                'date': date,
                'time': time
            })
            print("Event added successfully")
            break
        except ValueError:
            print("Invalid date or time format. Please use YYYY-MM-DD for date and HH:MM for time.")
            date = input("Enter date (YYYY-MM-DD): ")
            time = input("Enter time (HH:MM): ")


# Function to delete an event
def delete_event(title):

    global events
    length = len(events)
    # Filter out the event to delete
    events = [event for event in events if event['title'] != title]

    # Check if event was deleted
    if len(events) == length:
        print(f"Event '{title}' does not exist.")
    else:
        print("Event deleted successfully")


# Function to edit an existing event
def edit_event():

    title = input("Enter the title of the event you want to edit: ")

    found_event = None
    for event in events:
        if event['title'].lower() == title.lower():
            found_event = event
            break

    if found_event:
        print("Event found. Please provide new details:")
        title = input("Enter new title: ")
        description = input("Enter new description: ")
        date = input("Enter new date (YYYY-MM-DD): ")
        time = input("Enter new time (HH:MM): ")

        while True:
            try:
      
                year, month, day = map(int, date.split('-'))
                datetime.datetime(year=year, month=month, day=day)

              
                hours, minutes = map(int, time.split(':'))
                if hours < 0 or hours > 23 or minutes < 0 or minutes > 59:
                    raise ValueError

               
                found_event['title'] = title
                found_event['description'] = description
                found_event['date'] = date
                found_event['time'] = time
                print("Event updated successfully")
                break
            except ValueError:
                print("Invalid date or time format. Please use YYYY-MM-DD for date and HH:MM for time.")
                date = input("Enter new date (YYYY-MM-DD): ")
                time = input("Enter new time (HH:MM): ")
    else:
        print(f"No event with title '{title}' found.")


main()
