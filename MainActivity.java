package com.example.sep16second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String selectedItem, selectedItemtwo, selectedItemthree;
    private String selectedCountry, selectedDistrict, selectedState;                 //vars to hold the values of selected State and District
    private TextView tvCountrySpinner, tvStateSpinner, tvDistrictSpinner;             //declaring TextView to show the errors
    private Spinner countrySpinner, stateSpinner, districtSpinner;                  //Spinners
    private ArrayAdapter<CharSequence> countryAdapter, stateAdapter, districtAdapter;   //declare adapters for the spinners
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countrySpinner = findViewById(R.id.spinner_country);
        Button SubButton = (Button) findViewById(R.id.button_submit);
        dbHandler = new DBHandler(MainActivity.this);
        //Finds a view that was identified by the android:id attribute


        countryAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_country, R.layout.spinner_layout);

        // Specify the layout to use when the list of choices appear
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        countrySpinner.setAdapter(countryAdapter);            //Set the adapter to the spinner to populate the Country Spinner

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //State Spinner Initialisation

                selectedItem = parent.getItemAtPosition(position).toString();
//
                stateSpinner = findViewById(R.id.spinner_indian_states);    //Finds a view that was identified by the android:id attribute in xml
                selectedCountry = countrySpinner.getSelectedItem().toString();

                int parentID = parent.getId();
                if (parentID == R.id.spinner_country){
                    switch (selectedCountry){
                        case "Select Your Country": stateAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_default_state, R.layout.spinner_layout);
                            break;
                        case "India": stateAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_indian_states, R.layout.spinner_layout);
                            break;
                        default:  break;
                    }

                    // Specify the layout to use when the list of choices appear
                    stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    stateSpinner.setAdapter(stateAdapter);            //Set the adapter to the spinner to populate the State Spinner

                    //When any item of the stateSpinner is selected
                    stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            selectedItemtwo = parent.getItemAtPosition(position).toString();
//

                            //Define City Spinner but we will populate the options through the selected state
                            districtSpinner = findViewById(R.id.spinner_indian_districts);
                            selectedState = stateSpinner.getSelectedItem().toString();      //Obtain the selected State

                            int parentID = parent.getId();
                            if (parentID == R.id.spinner_indian_states){
                                switch (selectedState){
                                    case "Select Your State": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_default_districts, R.layout.spinner_layout);
                                        break;
                                    case "Andhra Pradesh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Arunachal Pradesh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_arunachal_pradesh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Assam": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_assam_districts, R.layout.spinner_layout);
                                        break;
                                    case "Bihar": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_bihar_districts, R.layout.spinner_layout);
                                        break;
                                    case "Chhattisgarh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_chhattisgarh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Goa": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_goa_districts, R.layout.spinner_layout);
                                        break;
                                    case "Gujarat": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_gujarat_districts, R.layout.spinner_layout);
                                        break;
                                    case "Haryana": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_haryana_districts, R.layout.spinner_layout);
                                        break;
                                    case "Himachal Pradesh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_himachal_pradesh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Jharkhand": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_jharkhand_districts, R.layout.spinner_layout);
                                        break;
                                    case "Karnataka": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_karnataka_districts, R.layout.spinner_layout);
                                        break;
                                    case "Kerala": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_kerala_districts, R.layout.spinner_layout);
                                        break;
                                    case "Madhya Pradesh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_madhya_pradesh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Maharashtra": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_maharashtra_districts, R.layout.spinner_layout);
                                        break;
                                    case "Manipur": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_manipur_districts, R.layout.spinner_layout);
                                        break;
                                    case "Meghalaya": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_meghalaya_districts, R.layout.spinner_layout);
                                        break;
                                    case "Mizoram": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_mizoram_districts, R.layout.spinner_layout);
                                        break;
                                    case "Nagaland": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_nagaland_districts, R.layout.spinner_layout);
                                        break;
                                    case "Odisha": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_odisha_districts, R.layout.spinner_layout);
                                        break;
                                    case "Punjab": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_punjab_districts, R.layout.spinner_layout);
                                        break;
                                    case "Rajasthan": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_rajasthan_districts, R.layout.spinner_layout);
                                        break;
                                    case "Sikkim": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_sikkim_districts, R.layout.spinner_layout);
                                        break;
                                    case "Tamil Nadu": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_tamil_nadu_districts, R.layout.spinner_layout);
                                        break;
                                    case "Telangana": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_telangana_districts, R.layout.spinner_layout);
                                        break;
                                    case "Tripura": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_tripura_districts, R.layout.spinner_layout);
                                        break;
                                    case "Uttar Pradesh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_uttar_pradesh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Uttarakhand": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_uttarakhand_districts, R.layout.spinner_layout);
                                        break;
                                    case "West Bengal": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_west_bengal_districts, R.layout.spinner_layout);
                                        break;
                                    case "Andaman and Nicobar Islands": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_andaman_nicobar_districts, R.layout.spinner_layout);
                                        break;
                                    case "Chandigarh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_chandigarh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Dadra and Nagar Haveli": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_dadra_nagar_haveli_districts, R.layout.spinner_layout);
                                        break;
                                    case "Daman and Diu": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_daman_diu_districts, R.layout.spinner_layout);
                                        break;
                                    case "Delhi": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_delhi_districts, R.layout.spinner_layout);
                                        break;
                                    case "Jammu and Kashmir": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_jammu_kashmir_districts, R.layout.spinner_layout);
                                        break;
                                    case "Lakshadweep": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_lakshadweep_districts, R.layout.spinner_layout);
                                        break;
                                    case "Ladakh": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_ladakh_districts, R.layout.spinner_layout);
                                        break;
                                    case "Puducherry": districtAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                            R.array.array_puducherry_districts, R.layout.spinner_layout);
                                        break;
                                    default:  break;
                                }

                                districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     // Specify the layout to use when the list of choices appears
                                districtSpinner.setAdapter(districtAdapter);        //Populate the list of Districts in respect of the State selected

                                //To obtain the selected District from the spinner
                                districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        selectedDistrict = districtSpinner.getSelectedItem().toString();
                                        selectedItemthree = parent.getItemAtPosition(position).toString();
//
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {
                                    }
                                });
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        Button submitButton;                                //To display the selected State and District
        submitButton = findViewById(R.id.button_submit);
        tvCountrySpinner = findViewById(R.id.textView_country);
        tvStateSpinner = findViewById(R.id.textView_indian_states);
        tvDistrictSpinner = findViewById(R.id.textView_indian_districts);

        submitButton.setOnClickListener(v -> {
            if (selectedCountry.equals("Select Your Country")) {
                Toast.makeText(MainActivity.this, "Please select your country from the list", Toast.LENGTH_LONG).show();
                tvCountrySpinner.setError("Country is required!");      //To set error on TextView
                tvCountrySpinner.requestFocus();
            } else if (selectedState.equals("Select Your State")) {
                Toast.makeText(MainActivity.this, "Please select your state from the list", Toast.LENGTH_LONG).show();
                tvStateSpinner.setError("State is required!");      //To set error on TextView
                tvStateSpinner.requestFocus();
            } else if (selectedDistrict.equals("Select Your District")) {
                Toast.makeText(MainActivity.this, "Please select your district from the list", Toast.LENGTH_LONG).show();
                tvDistrictSpinner.setError("District is required!");
                tvDistrictSpinner.requestFocus();
                tvStateSpinner.setError(null);                      //To remove error from stateSpinner
            } else {
                tvStateSpinner.setError(null);
                tvDistrictSpinner.setError(null);
                Toast.makeText(MainActivity.this, "Selected Country: "+selectedCountry+"\nSelected State: "+selectedState+"\nSelected District: "+selectedDistrict, Toast.LENGTH_LONG).show();
            }
        });







        //Country Spinner Initialisation
//        countryAdapter = ArrayAdapter.createFromResource(this,
//                R.array.array_country, R.layout.spinner_layout);
//
//        // Specify the layout to use when the list of choices appear
//        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        countrySpinner.setAdapter(countryAdapter);
//        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
////                String TempListViewClickedValue = countryAdapter.get(position).toString();
//                 selectedItem = parent.getItemAtPosition(position).toString();
//                // make insertion into database
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {}
//        });
//

        SubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
//                String courseName = courseNameEdt.getText().toString();

                String courseName = selectedItem;
                String courseNametwo = selectedItemtwo;
                String courseNamethree = selectedItemthree;
                // validating if the text fields are empty or not.
                if (courseName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewCourse(courseName,courseNametwo,courseNamethree);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
//                selectedItem.setText("");

            }
        });


    }
}