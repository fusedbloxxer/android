package com.code_challenges.traveljournal;

public class IntentRequests {
    public static final int ADD_TRAVEL_PLAN_REQUEST = 1;
    public static final int DATE_PICKER_START = 3;
    public static final int DATE_PICKER_END = 4;

    public static final String ERROR_EMPTY_STRING = "Field is empty.";
    public static final String TRIP_NAME = "trip_name";
    public static final String TRIP_LOCATION = "trip_location";
    public static final String TRIP_TYPE = "trip_type";
    public static final String TRIP_PRICE = "trip_price";
    public static final String TRIP_START_DATE = "trip_start_date";
    public static final String TRIP_END_DATE = "trip_end_date";
    public static final String TRIP_RATING = "trip_rating";
    public static final String BUTTON_DATE_PICKER = "date_picker";
    public static final String DATE = "date";

    private static class SingleTonHelper {
        public static final IntentRequests INSTANCE = new IntentRequests();
    }

    public static IntentRequests getInstance() {
        return SingleTonHelper.INSTANCE;
    }

    private IntentRequests() {

    }
}
