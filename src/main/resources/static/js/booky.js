document.addEventListener("DOMContentLoaded", () => {
    loadBooks();
});

function loadBooks() {
    fetch('/Booky/api/books')
        .then(response => response.json())
        .then(data => {
            const bookList = document.getElementById('bookList');
            bookList.innerHTML = '';
            data.forEach(book => {
                const bookDiv = document.createElement('div');
                bookDiv.classList.add('book');
                bookDiv.innerHTML = `
                    <img src="${book.imageUrl}" alt="${book.title}" class="book-image">
                    <h3>${book.title}</h3>
                    <p>Autor: ${book.author}</p>
                    <p>Preis: ${book.price} €</p>
                    <p>${book.description}</p>
                    <p>${book.sellerProfile}</p>
                    <button onclick="buyBook(${book.id})" class="buy-button">Kaufen</button>
                `;
                bookList.appendChild(bookDiv);
            });
        })
        .catch(error => console.error('Fehler beim Laden der Bücher:', error));
}

function searchBooks() {
    const query = document.getElementById('searchInput').value;
    fetch(`/Booky/api/books/search?query=${query}`)
        .then(response => response.json())
        .then(data => {
            const bookList = document.getElementById('bookList');
            bookList.innerHTML = '';
            data.forEach(book => {
                const bookDiv = document.createElement('div');
                bookDiv.classList.add('book');
                bookDiv.innerHTML = `
                    <img src="${book.imageUrl}" alt="${book.title}" class="book-image">
                    <h3>${book.title}</h3>
                    <p>Autor: ${book.author}</p>
                    <p>Preis: ${book.price} €</p>
                    <p>${book.description}</p>
                    <p>${book.sellerProfile}</p>
                    <button onclick="buyBook(${book.id})" class="buy-button">Kaufen</button>
                `;
                bookList.appendChild(bookDiv);
            });
        })
        .catch(error => console.error('Fehler bei der Suche nach Büchern:', error));
}

function buyBook(bookId) {
    alert(`Buch mit der ID ${bookId} wurde gekauft!`);
}