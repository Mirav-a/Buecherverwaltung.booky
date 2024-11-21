<template>
  <div class="card h-100 shadow-sm">
    <div class="card-body">
      <h5 class="card-title">{{ book.title }}</h5>
      <p class="card-text">Autor: {{ book.author }}</p>
    </div>
    <div class="card-footer text-end">
      <button class="btn btn-primary">Details anzeigen</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'BookItem',
  props: {
    book: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style scoped>
.card {
  border-radius: 10px;
}

.card-title {
  font-weight: bold;
}

.card-footer {
  background-color: transparent;
}
</style>
