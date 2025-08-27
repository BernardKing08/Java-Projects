// ==================== PAYMENT HANDLING ====================
  // Handle apply button click
  document.getElementById('applyButton').addEventListener('click', function() {
    if (!currentRoomData) {
      logDebug('No room data available', 'error');
      showError('Please select a room first.');
      return;
    }
    
    logDebug(`Apply button clicked for room: ${currentRoomData.title}`);
    
    // Get current user email from meta tags
    const userEmail = getCurrentUserEmail();
    
    if (!userEmail) {
      logDebug('No current user found', 'error');
      showError('User information not found. Please refresh the page and try again.');
      return;
    }
    
    logDebug(`Initiating payment for room ${currentRoomData.id} with user email ${userEmail}`);
    
    // Close property modal first with proper error handling
    try {
      const propertyModalElement = document.getElementById('propertyModal');
      const propertyModal = bootstrap.Modal.getInstance(propertyModalElement);
      
      if (propertyModal) {
        propertyModal.hide();
        logDebug('Property modal closed successfully');
      } else {
        // If no instance exists, try to get it differently or create new one
        const newModal = new bootstrap.Modal(propertyModalElement);
        newModal.hide();
        logDebug('Property modal closed via new instance');
      }
    } catch (error) {
      logDebug(`Error closing property modal: ${error.message}`, 'error');
      // Continue anyway, don't let modal issues block payment
    }
    
    // Show processing modal
    try {
      const processingModalElement = document.getElementById('processingModal');
      if (processingModalElement) {
        const processingModal = new bootstrap.Modal(processingModalElement);
        processingModal.show();
        logDebug('Processing modal shown successfully');
      }
    } catch (error) {
      logDebug(`Error showing processing modal: ${error.message}`, 'error');
    }
    
    // Small delay to ensure modal transition completes
    setTimeout(() => {
      initPayment(currentRoomData.id, userEmail);
    }, 300);
  });

  // Initialize payment by calling backend
  function initPayment(roomId, userEmail) {
    try {
      logDebug(`Submitting payment form for room ${roomId}`);
      
      // Set form values
      document.getElementById('userEmailInput').value = userEmail;
      const paymentForm = document.getElementById('paymentForm');
      paymentForm.action = `/payments/init/${roomId}`;
      
      // Submit the form - this will redirect to Paystack or back with error
      paymentForm.submit();
      
    } catch (error) {
      logDebug(`Error initializing payment: ${error.message}`, 'error');
      hideProcessingModal();
      showError('Error initializing payment: ' + error.message);
    }
  }