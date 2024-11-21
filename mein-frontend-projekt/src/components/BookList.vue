<template>
  <div class="container mt-5">
    <h2 class="mb-4 text-center">Bücherliste</h2>
    <div class="row">
      <BookItem
          v-for="book in books"
          :key="book.id"
          :book="book"
          class="col-md-4 mb-4"
      />
    </div>
  </div>
</template>

<script>
import BookItem from './BookItem.vue';

export default {
  name: 'BookList',
  components: {
    BookItem,
  },
  data() {
    return {
      books: [
        {id: 1, title: '1984', author: 'George Orwell'},
        {id: 2, title: 'Der Herr der Ringe', author: 'J.R.R. Tolkien'},
        {id: 3, title: 'Die unendliche Geschichte', author: 'Michael Ende'},
      ],
    };
  },
};
</script>

<style scoped>
h2 {
  color: #c4a8a8;
}
</style>
