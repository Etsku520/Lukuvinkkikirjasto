Feature: As a user I want to edit items

    Scenario: ui works correctly
        Given item "Title" "Author" "url" exists in the application
        When items are listed
        And user does nothing
        Then system will respond with "Welcome to the CS literature recommendation system!"
        And system will respond with 
            """
            quit = quit the application
            new = add a new item
            list = list items
            edit = edit item
            """
        And system will respond with "Book: Title by Author url"

    Scenario: user can edit an book title
        Given command "edit" is entered
        And item "Title" "Author" "url" exists in the application
        When edit commands "0" "title" "New Title" are entered
        When items are listed
        And user does nothing
        And system will respond with "Book: New Title by Author url"

    Scenario: user can edit an book author
        Given command "edit" is entered
        And item "Title" "Author" "url" exists in the application
        When edit commands "0" "author" "New Author" are entered
        When items are listed
        And user does nothing
        And system will respond with "Book: Title by New Author url"

    Scenario: user can edit an book url
        Given command "edit" is entered
        And item "Title" "Author" "url" exists in the application
        When edit commands "0" "url" "New Url" are entered
        When items are listed
        And user does nothing
        And system will respond with "Book: Title by Author New Url"

    Scenario: user can edit an book title when multiple books exist
        Given command "edit" is entered
        And item "Title" "Author" "url" exists in the application
        And item "Learn Python" "Developer" "www.google.com" exists in the application
        When edit commands "1" "url" "www.youtube.com" are entered
        When items are listed
        And user does nothing
        And system will respond with "Book: Title by Author url"
        And system will respond with "Book: Learn Python by Developer www.youtube.com"