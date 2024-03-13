package org.example.no332;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Stack;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> ticketMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (ticketMap.containsKey(from)) {
                ticketMap.get(from).add(to);
            } else {
                ticketMap.put(from,new PriorityQueue<String>(){{
                    add(to);
                }});
            }
        }
        Deque<String> itineraryDeque = new ArrayDeque<>();
        Stack<String> stack = new Stack<String>(){{
            push("JFK");
        }};
        while (!stack.isEmpty()) {
            String begin = stack.peek();
            PriorityQueue<String> toPriorityQueue = ticketMap.get(begin);
            if (Objects.isNull(toPriorityQueue) || toPriorityQueue.isEmpty()) {
                itineraryDeque.addFirst(begin);
                stack.pop();
            } else {
                String to = toPriorityQueue.poll();
                stack.push(to);
            }
        }
        return new ArrayList<>(itineraryDeque);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<List<String>>() {{
            add(new ArrayList<String>() {{
                add("EZE");
                add("AXA");
            }});

            add(new ArrayList<String>() {{
                add("TIA");
                add("ANU");
            }});

            add(new ArrayList<String>() {{
                add("ANU");
                add("JFK");
            }});

            add(new ArrayList<String>() {{
                add("JFK");
                add("ANU");
            }});

            add(new ArrayList<String>() {{
                add("ANU");
                add("EZE");
            }});

            add(new ArrayList<String>() {{
                add("TIA");
                add("ANU");
            }});

            add(new ArrayList<String>() {{
                add("AXA");
                add("TIA");
            }});

            add(new ArrayList<String>() {{
                add("TIA");
                add("JFK");
            }});

            add(new ArrayList<String>() {{
                add("ANU");
                add("TIA");
            }});

            add(new ArrayList<String>() {{
                add("JFK");
                add("TIA");
            }});
        }};

        List<String> itineraryList = new ReconstructItinerary().findItinerary(tickets);
        System.out.println(itineraryList.toString());
    }

}
