package com.test.linkedlist;

import com.test.model.PaymentRequest;
import com.test.model.PaymentState;
import java.util.LinkedList;
import java.util.Map;

public class TestLinkedList {

    public static void printFirstAndLastPaymentState(PaymentRequest paymentRequest,
            Map<PaymentRequest, LinkedList<PaymentState>> paymentRequestLinkedListMap) {

        LinkedList<PaymentState> paymentState = paymentRequestLinkedListMap.get(paymentRequest);
        System.out.println("First state: " + paymentState.getFirst() + " Last state: " + paymentState.getLast());
        System.out.println();
    }
}
