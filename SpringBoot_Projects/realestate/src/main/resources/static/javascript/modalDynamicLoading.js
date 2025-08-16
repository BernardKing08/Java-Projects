document.querySelectorAll('.view-details-btn').forEach(btn => {
  btn.addEventListener('click', function () {
    document.getElementById('modalTitle').textContent = this.dataset.title;
    document.getElementById('modalBath').textContent = this.dataset.bath + ' Bath';
    document.getElementById('modalRoom').textContent = this.dataset.rooms + ' Beds';
    document.getElementById('modalFloor').textContent = 'Floor ' + this.dataset.floor;
    document.getElementById('modalAddress').textContent = this.dataset.location;
    document.getElementById('modalDescription').textContent = this.dataset.description;
    document.getElementById('modalImage').src = this.dataset.image;
  });
});
