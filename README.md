<!-- PROJECT LOGO -->
<a name="readme-top"></a>
<br />
<div align="center">

  ![Logo](https://github.com/ELDA7EE7/OOP-project-2.0/assets/114913488/9c0d4995-784c-43b8-9a5b-3f4abc74163f)

  <p align="center">
    Library Management System Project made for the OOP course at Faculty of Computer and Information Science, Ain Shams University.
    <br />
    <br />
    <a href="https://github.com/ELDA7EE7/OOP-project-2.0"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/ELDA7EE7/OOP-project-2.0">View Demo</a>
    ·
    <a href="https://github.com/ELDA7EE7/OOP-project-2.0/issues">Report Bug</a>
    ·
    <a href="https://github.com/ELDA7EE7/OOP-project-2.0/issues">Request Feature</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#system-description">System Description</a>
      <ul>
        <li><a href="#user-functionalities">User Functionalities</a></li>
        <li><a href="#admin-functionalities">Admin Functionalities</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#extra-documentation-and-studies">Extra Documentation and Studies</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
# About The Project

![Splash Screen](https://github.com/ELDA7EE7/OOP-project-2.0/assets/114913488/86c677a2-2aae-4df3-a6e2-2931f28fd2c9)


This comprehensive and feature-rich system is designed to streamline the operations of a bookstore, offering both users and administrators an intuitive and efficient platform. With functionalities ranging from user registration and book browsing to detailed order and borrowing histories, this system aims to provide a seamless experience for both customers and bookstore administrators.

### Built With

* [![Java][Java.js]][Java-url]

<p align="right"><a href="#readme-top">back to top</a></p>

# System Description

### User Functionalities:
#### •	Registration: New users can create an account by providing their name and email address. The system generates a unique customer ID and stores it along with the user's information.
#### •	Login: Existing users can enter their email address and password to access the system.
#### •	Browsing and Searching: Users can browse through the available books in various ways:
* Home page: See featured books and best deals.
* Categories screen: View books categorized by genre, author, or other criteria.
* Search screen: Search for books by title or author keyword.
#### •	Book details: Users can view details of a specific book, including title, author, publication year, price, description, and availability status. They can also:
*	Add to cart: Add the book to their shopping cart for purchase.
*	Borrow (if available): Registered users can borrow available books. The system records the transaction with the borrow date and sets a due date for return.
*	Rate and review: Leave a rating and review for the book, visible to other users.
#### •	Shopping cart: Users can manage their shopping cart, including:
*	Viewing the list of added books, quantity, and total price.
*	Updating the quantity of each book.
*	Applying promo codes (if applicable).
*	Choosing a payment method (cash on delivery or credit card).
#### •	Order history: Registered users can view their past orders, including the date, books purchased, and total amount paid.
#### •	Borrowing history: Registered users can view their borrowing history, including the borrowed books, borrow and return dates, and any associated fines.

### Admin Functionalities:
#### •	Book management:
*	Add new books: Add new books to the system by providing details like title, author, publication year, price, and availability.
*	Update book information: Edit existing book details like price, availability, or description.
*	Remove books: Remove books from the system that are no longer available or needed.
#### •	Borrower management:
*	Add new borrowers: Register new borrowers with their name and contact information.
*	Update borrower details: Edit existing borrower information like contact details or address.
*	Remove borrowers: Remove borrowers from the system who are no longer active or have violated policies.

<p align="right"><a href="#readme-top">back to top</a></p>



<!-- USAGE EXAMPLES -->
# Usage

## Input and Output Scenarios:
### Login 
* Input: User enters their email address and password.
* Output: System verifies credentials. If successful, system displays the user's home page. If unsuccessful, system displays an error message.
  
![Screenshot ١٢-٢٧-٢٠٢٣ ٠٧ ٠٢ ١٥](https://github.com/ELDA7EE7/OOP-project-2.0/assets/114913488/6d4253b7-93ac-427c-8f95-2f3a65329cf3)


### Registration 
* Input: User enters their name and email address. User creates a password.
* Output: System creates a new customer account with a unique ID.

![Screenshot ١٢-٢٧-٢٠٢٣ ٠٧ ٠٢ ٢٧](https://github.com/ELDA7EE7/OOP-project-2.0/assets/114913488/e307c6da-ee36-407e-9a82-11e66d428b55)


### Searching for a book
* Input: User types a keyword (title or author) in the search bar.
* Output: System displays a list of matching books with titles, authors.

![Screenshot ١٢-٢٧-٢٠٢٣ ٠٧ ٠٦ ١٨](https://github.com/ELDA7EE7/OOP-project-2.0/assets/114913488/389ec628-ae0d-43e8-9426-69cf9316f417)


### Borrowing a book
* Input: User clicks the "Borrow" button on a book's details page.
* Output: System checks book availability. If available, system records the borrowing transaction with the borrow date and due date. System displays a confirmation message and sends a notification to the user. If not available, system displays a message indicating the book is unavailable and may offer options to reserve or be notified when it becomes available.

![image](https://github.com/ELDA7EE7/OOP-project-2.0/assets/114913488/957568c5-2331-4fa1-a83b-6493efff0fd1)


### Adding a book to the shopping cart
* Input: User clicks the "Add to Cart" button on a book's details page. User specifies quantity (if applicable).
* Output: System adds the book to the user's shopping cart, updating the total price.

![Screenshot ١٢-٢٧-٢٠٢٣ ٠٧ ٠٨ ٣٦](https://github.com/ELDA7EE7/OOP-project-2.0/assets/114913488/6ad87b44-38fb-4556-a5b7-71fcec887a33)
![Screenshot ١٢-٢٧-٢٠٢٣ ٠٧ ٠٧ ٥٤](https://github.com/ELDA7EE7/OOP-project-2.0/assets/114913488/6f4653b7-befd-4eb0-ba57-25eb5cce4af8)


### Adding a new book
* Input: Admin enters book details: title, author, publication year, price, availability, and description.
* Output: System creates a new book object and adds it to the catalog.

![Screenshot ١٢-٢٧-٢٠٢٣ ٠٧ ٠٤ ٢٩](https://github.com/ELDA7EE7/OOP-project-2.0/assets/114913488/4d19c18a-ad1c-4174-8816-81e6e687e336)


### Updating book information
* Input: Admin selects a book to update. Admin modifies desired fields (e.g., price, availability).
* Output: System updates the book's information in the catalog.

![Screenshot ١٢-٢٧-٢٠٢٣ ٠٧ ٠٤ ٢٠](https://github.com/ELDA7EE7/OOP-project-2.0/assets/114913488/84d174c6-62d4-4a4a-814b-e33f43854284)


<p align="right"><a href="#readme-top">back to top</a></p>

<!-- CONTRIBUTING -->
# Extra Documentation and Studies

### [UML Diagram](https://drive.google.com/file/d/15DKX1cpXYcr4WeUYd-v6bjtgYUV0-6Rs/view?usp=sharing)
### [Brand Guidelines](https://www.behance.net/gallery/187621769/ByteBibliotheca-Brand-Guidelines)
### [UI / UX Case Study](https://www.behance.net/gallery/187613467/ByteBibliotheca-UI-UX-Case-Study)

<p align="right"><a href="#readme-top">back to top</a></p>

<!-- CONTRIBUTING -->
# Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right"><a href="#readme-top">back to top</a></p>



<!-- LICENSE -->
# License

MIT License

Copyright (c) [2023] [ByteBibliotheca]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

<p align="right"><a href="#readme-top">back to top</a></p>





<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png
[Java.js]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/en/
