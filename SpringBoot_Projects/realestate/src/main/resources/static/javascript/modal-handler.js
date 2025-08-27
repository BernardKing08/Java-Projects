// ==================== MODAL DATA HANDLING ====================
  // Store current room data for payment
  let currentRoomData = null;

  // Handle view details button clicks
  document.querySelectorAll('.view-details-btn').forEach(btn => {
    btn.addEventListener('click', function() {
      // Store room data for later use
      currentRoomData = {
        id: this.dataset.roomid,
        title: this.dataset.title,
        bath: this.dataset.bath,
        rooms: this.dataset.rooms,
        floor: this.dataset.floor,
        location: this.dataset.location,
        description: this.dataset.description,
        image: this.dataset.image,
        price: this.dataset.price
      };
      
      // Update modal content
      document.getElementById('modalTitle').textContent = this.dataset.title;
      document.getElementById('modalBath').textContent = this.dataset.bath + ' Bath';
      document.getElementById('modalRoom').textContent = this.dataset.rooms + ' Beds';
      document.getElementById('modalFloor').textContent = 'Floor ' + this.dataset.floor;
      document.getElementById('modalAddress').textContent = this.dataset.location;
      document.getElementById('modalDescription').textContent = this.dataset.description;
      document.getElementById('modalImage').src = this.dataset.image;
      document.getElementById('modalPrice').textContent = '₦' + parseFloat(this.dataset.price).toLocaleString();
      
      // Update current user display
      updateCurrentUserDisplay();
      
      logDebug(`Modal loaded for room: ${this.dataset.title}`);
    });
  });