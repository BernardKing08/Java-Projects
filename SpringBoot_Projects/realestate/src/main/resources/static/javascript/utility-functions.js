// ==================== UTILITY FUNCTIONS ====================
  // Hide processing modal
  function hideProcessingModal() {
    try {
      const processingModalElement = document.getElementById('processingModal');
      if (processingModalElement) {
        const processingModal = bootstrap.Modal.getInstance(processingModalElement);
        if (processingModal) {
          processingModal.hide();
          logDebug('Processing modal hidden successfully');
        } else {
          logDebug('No processing modal instance found');
        }
      } else {
        logDebug('Processing modal element not found');
      }
    } catch (error) {
      logDebug(`Error hiding processing modal: ${error.message}`, 'error');
    }
  }

  // Debug functions
  function logDebug(message, type = 'info') {
    const debugContent = document.getElementById('debugContent');
    if (debugContent) {
      const logEntry = document.createElement('div');
      logEntry.className = `debug-log debug-${type}`;
      logEntry.textContent = `[${new Date().toLocaleTimeString()}] ${message}`;
      debugContent.appendChild(logEntry);
      debugContent.scrollTop = debugContent.scrollHeight;
    }
    
    // Also log to console
    console.log(`[${type.toUpperCase()}] ${message}`);
  }
  
  function toggleDebug() {
    const content = document.getElementById('debugContent');
    const toggle = document.querySelector('.debug-toggle');
    if (content && toggle) {
      if (content.classList.contains('debug-hidden')) {
        content.classList.remove('debug-hidden');
        toggle.textContent = 'Hide';
      } else {
        content.classList.add('debug-hidden');
        toggle.textContent = 'Show';
      }
    }
  }

  // ==================== INITIALIZATION ====================
  // Handle page load and URL parameters
  document.addEventListener('DOMContentLoaded', function() {
    logDebug('Page loaded successfully');
    
    // Add staggered animation delays to cards
    const cards = document.querySelectorAll('.col');
    cards.forEach((card, index) => {
      card.style.animationDelay = `${index * 0.1}s`;
    });
    
    // Check for success or error in URL parameters
    const urlParams = new URLSearchParams(window.location.search);
    
    if (urlParams.has('success')) {
      // Success message will be shown via Bootstrap alert, but also show modal
      setTimeout(() => {
        showSuccess();
      }, 1000);
      
      // Clean URL
      window.history.replaceState({}, document.title, window.location.pathname);
    }
    
    if (urlParams.has('error')) {
      // Error message will be shown via Bootstrap alert
      const errorParam = urlParams.get('error');
      setTimeout(() => {
        if (errorParam !== 'null' && errorParam !== '') { 
          showError(errorParam);
        }
      }, 1000);
      
      // Clean URL  
      window.history.replaceState({}, document.title, window.location.pathname);
    }

    // Auto-dismiss alerts after 5 seconds
    setTimeout(() => {
      const alerts = document.querySelectorAll('.alert-dismissible');
      alerts.forEach(alert => {
        const bsAlert = new bootstrap.Alert(alert);
        bsAlert.close();
      });
    }, 5000);

    // Add smooth scroll behavior
    document.documentElement.style.scrollBehavior = 'smooth';
  });

  // Handle browser back button after payment
  window.addEventListener('pageshow', function(event) {
    if (event.persisted) {
      // Page was loaded from cache (user hit back button)
      hideProcessingModal();
      logDebug('Page loaded from cache, hiding processing modal');
    }
  });

  // Handle beforeunload to hide processing modal
  window.addEventListener('beforeunload', function() {
    hideProcessingModal();
  });

  // Add intersection observer for card animations
  if ('IntersectionObserver' in window) {
    const observer = new IntersectionObserver((entries) => {
      entries.forEach(entry => {
        if (entry.isIntersecting) {
          entry.target.style.opacity = '1';
          entry.target.style.transform = 'translateY(0)';
        }
      });
    }, { threshold: 0.1 });

    // Observe all cards
    document.querySelectorAll('.card').forEach(card => {
      observer.observe(card);
    });
  }