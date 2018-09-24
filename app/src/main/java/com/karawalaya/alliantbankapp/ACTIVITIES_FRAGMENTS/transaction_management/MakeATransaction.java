package com.karawalaya.alliantbankapp.ACTIVITIES_FRAGMENTS.transaction_management;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.karawalaya.alliantbankapp.DAO_SERVICE.transaction_management.TransactionManagementDAO;
import com.karawalaya.alliantbankapp.POJO_MODEL.transaction_management.Account;
import com.karawalaya.alliantbankapp.POJO_MODEL.transaction_management.Customer;
import com.karawalaya.alliantbankapp.POJO_MODEL.transaction_management.Transaction;
import com.karawalaya.alliantbankapp.R;

import java.util.Collection;

public class MakeATransaction extends Fragment implements View.OnClickListener {
    //Bundle Arguments.
    private static final String CUST_VAR_MAKE_A_TRANSACTION = "customer";

    //Special Holding Attributes.
    private Customer customer = null;
    Account account = null;
    private TransactionManagementDAO tmdao;

    //Views.
    private TextView make_a_transaction_TV02;
    private TextView make_a_transaction_TV04;
    private TextView make_a_transaction_TV06;
    private EditText make_a_transaction_ET01;
    private EditText make_a_transaction_ET02;
    private Button make_a_transaction_BTN01;

    /**
     * This was used to create a communication between the MainActivity and this fragment.
     */
    public static MakeATransaction getInstance(Customer cust) {
        MakeATransaction makeATransactionFrag = new MakeATransaction();
        Bundle makeATransactionBundle = new Bundle();
        makeATransactionBundle.putSerializable(CUST_VAR_MAKE_A_TRANSACTION, cust);
        makeATransactionFrag.setArguments(makeATransactionBundle);

        return makeATransactionFrag;
    }

    @Override
    public void onAttach(Context context) {
        Log.i("Kara", "FRAGMENT =========================== MakeATransaction =========================== onAttach ===========================");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("Kara", "FRAGMENT =========================== MakeATransaction =========================== onCreate ===========================");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("Kara", "FRAGMENT =========================== MakeATransaction =========================== onCreateView ===========================");

        View fragMakeATransactionView = inflater.inflate(R.layout.fragment_make_atransaction, container, false);

        initializeObjects();
        initializeViews(fragMakeATransactionView);

        if(getArguments() != null) {
            customer = (Customer) getArguments().getSerializable(CUST_VAR_MAKE_A_TRANSACTION);
            make_a_transaction_TV02.setText(customer.getFirstName() + " " + customer.getLastName());

            account = tmdao.getAccountDetails(customer);
            if(account != null) {
                make_a_transaction_TV04.setText(Integer.toString(account.getAccountNo()));
                make_a_transaction_TV06.setText(Double.toString(account.getBalance()));

                make_a_transaction_BTN01.setOnClickListener(this);
            } else {
                make_a_transaction_BTN01.setVisibility(View.INVISIBLE);
            }
        }

        return fragMakeATransactionView;
    }

    private void initializeObjects() {
        tmdao = new TransactionManagementDAO(getActivity());
    }

    private void initializeViews(View fragMakeATransactionView) {
        make_a_transaction_TV02 = (TextView) fragMakeATransactionView.findViewById(R.id.make_a_transaction_TV02);
        make_a_transaction_TV04 = (TextView) fragMakeATransactionView.findViewById(R.id.make_a_transaction_TV04);
        make_a_transaction_TV06 = (TextView) fragMakeATransactionView.findViewById(R.id.make_a_transaction_TV06);

        make_a_transaction_ET01 = (EditText) fragMakeATransactionView.findViewById(R.id.make_a_transaction_ET01);;
        make_a_transaction_ET02 = (EditText) fragMakeATransactionView.findViewById(R.id.make_a_transaction_ET02);;
        make_a_transaction_BTN01 = (Button) fragMakeATransactionView.findViewById(R.id.make_a_transaction_BTN01);;
    }

    @Override
    public void onClick(View view) {
        Log.e("Kara", "Debit Account = " + make_a_transaction_ET01.getText().toString());
        Log.e("Kara", "Transfer Amount = " + make_a_transaction_ET02.getText().toString());

        int debitAccount = Integer.parseInt(make_a_transaction_ET01.getText().toString());
        double transferAmount = Double.parseDouble(make_a_transaction_ET02.getText().toString());


        if(tmdao.makeATransaction(account, debitAccount, transferAmount)) {
            emptyInputEditText();
            Toast.makeText(getActivity(),  "Transaction Successful", Toast.LENGTH_LONG).show();
        }
        else {
            emptyInputEditText();
            Toast.makeText(getActivity(),  "Transaction Unsuccessful", Toast.LENGTH_LONG).show();
        }

    }

    private void emptyInputEditText() {
        make_a_transaction_ET01.setText(null);
        make_a_transaction_ET02.setText(null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("Kara", "FRAGMENT =========================== MakeATransaction =========================== onActivityCreated ===========================");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i("Kara", "FRAGMENT =========================== MakeATransaction =========================== onStart ===========================");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i("Kara", "FRAGMENT =========================== MakeATransaction =========================== onResume  ===========================");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("Kara", "FRAGMENT =========================== MakeATransaction =========================== onPause ===========================");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i("Kara", "FRAGMENT =========================== MakeATransaction =========================== onStop ===========================");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i("Kara", "FRAGMENT =========================== MakeATransaction =========================== onDestroyView ===========================");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i("Kara", "FRAGMENT =========================== MakeATransaction =========================== onDestroy ===========================");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i("Kara", "FRAGMENT =========================== MakeATransaction =========================== onDetach ===========================");
        super.onDetach();
    }
}