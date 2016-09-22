package com.example.mershov.contactslist;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    ListView lvContacts;
    SimpleCursorAdapter scAdapter;
    Cursor mContacts;
	int i;
	int ii;
	String masterBranch;
	String masterBranch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContacts = getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,
                new String [] {ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME},
                null,//ContactsContract.Contacts.HAS_PHONE_NUMBER + " = ?",
                null,//new String[] {"1"},
                ContactsContract.Contacts.DISPLAY_NAME + " ASC"
        );

        String[] mContactsColumns = {
                ContactsContract.Contacts.DISPLAY_NAME
        };

        int[] mContactsListItems = {R.id.tvName};

        scAdapter = new SimpleCursorAdapter(
                getApplicationContext(),
                R.layout.item,
                mContacts,
                mContactsColumns,
                mContactsListItems,
                0
        );

        lvContacts = (ListView) findViewById(R.id.lvContacts);
        lvContacts.setAdapter(scAdapter);
    }
}
