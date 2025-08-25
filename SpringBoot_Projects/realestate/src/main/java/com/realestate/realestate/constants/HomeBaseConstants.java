package com.realestate.realestate.constants;

public interface HomeBaseConstants {
    // Accommodation Status
    public static final String NONE = "None";
    public static final String PENDING = "Pending";
    public static final String APPROVED = "Approved";  // Fixed: was "Rejected"
    public static final String REJECTED = "Rejected";  // Added missing constant
    
    // General Status
    public static final String ACTIVE = "Active";
    public static final String OPEN = "Open";
    public static final String CLOSE = "Close";

    // Roles
    public static final String ROLE_USER = "User";
    public static final String ROLE_ADMIN = "Admin";
}