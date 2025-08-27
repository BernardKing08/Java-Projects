// ==================== USER HANDLING ====================
  /**
   * Get current user email from meta tags
   */
  function getCurrentUserEmail() {
    const userEmailMeta = document.querySelector('meta[name="current-user-email"]');
    if (userEmailMeta && userEmailMeta.getAttribute('content')) {
      return userEmailMeta.getAttribute('content');
    }
    
    // Fallback: try Thymeleaf inline
    const thymeleafEmail = /*[[${currentUser?.email}]]*/ null;
    if (thymeleafEmail) {
      return thymeleafEmail;
    }
    
    return null;
  }

  /**
   * Get current user ID from meta tags
   */
  function getCurrentUserId() {
    const userIdMeta = document.querySelector('meta[name="current-user-id"]');
    if (userIdMeta && userIdMeta.getAttribute('content')) {
      return userIdMeta.getAttribute('content');
    }
    
    // Fallback: try Thymeleaf inline
    const thymeleafUserId = /*[[${currentUser?.id}]]*/ null;
    if (thymeleafUserId) {
      return thymeleafUserId;
    }
    
    return null;
  }

  /**
   * Get current user name from meta tags
   */
  function getCurrentUserName() {
    const userNameMeta = document.querySelector('meta[name="current-user-name"]');
    if (userNameMeta && userNameMeta.getAttribute('content')) {
      return userNameMeta.getAttribute('content');
    }
    
    // Fallback: try Thymeleaf inline
    const thymeleafUserName = /*[[${currentUser?.name}]]*/ null;
    if (thymeleafUserName) {
      return thymeleafUserName;
    }
    
    return null;
  }

  /**
   * Update current user display in modal
   */
  function updateCurrentUserDisplay() {
    const userEmail = getCurrentUserEmail();
    const userName = getCurrentUserName();
    const userDisplay = document.getElementById('currentUserDisplay');
    const userText = document.getElementById('currentUserText');
    
    if ((userEmail || userName) && userDisplay && userText) {
      const displayText = userName ? `${userName} (${userEmail})` : userEmail;
      userText.textContent = displayText;
      userDisplay.style.display = 'block';
      logDebug(`Current user display updated: ${displayText}`);
    } else if (userDisplay) {
      userDisplay.style.display = 'none';
      logDebug('No current user found for display');
    }
  }

  // Validate email format
  function isValidEmail(email) {
    if (!email || typeof email !== 'string') {
      return false;
    }
    
    // Basic email regex - more permissive for better UX
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email.trim());
  }

  /**
   * Update email display in modal
   */
  function updateEmailDisplay() {
    const storedEmail = getStoredEmail();
    const emailDisplay = document.getElementById('userEmailDisplay');
    const emailText = document.getElementById('userEmailText');
    
    if (storedEmail && emailDisplay && emailText) {
      emailText.textContent = storedEmail;
      emailDisplay.style.display = 'block';
    } else if (emailDisplay) {
      emailDisplay.style.display = 'none';
    }
  }

  /**
   * Clear stored email (useful for testing or if user wants to change email)
   */
  function clearStoredEmail() {
    sessionStorage.removeItem('userEmail');
    logDebug('Stored email cleared');
  }

  /**
   * Get stored email for display purposes
   */
  function getStoredEmail() {
    return sessionStorage.getItem('userEmail');
  }
