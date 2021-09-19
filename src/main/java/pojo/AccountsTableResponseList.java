package pojo;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AccountsTableResponseList {
    private List<AccountsTableResponse> accountsTableResponses = new List<AccountsTableResponse>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<AccountsTableResponse> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(AccountsTableResponse accountsTableResponse) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends AccountsTableResponse> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends AccountsTableResponse> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public AccountsTableResponse get(int index) {
            return null;
        }

        @Override
        public AccountsTableResponse set(int index, AccountsTableResponse element) {
            return null;
        }

        @Override
        public void add(int index, AccountsTableResponse element) {

        }

        @Override
        public AccountsTableResponse remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<AccountsTableResponse> listIterator() {
            return null;
        }

        @Override
        public ListIterator<AccountsTableResponse> listIterator(int index) {
            return null;
        }

        @Override
        public List<AccountsTableResponse> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    public List<AccountsTableResponse> getAccountsTableResponses() {
        return accountsTableResponses;
    }

    public void setAccountsTableResponses(List<AccountsTableResponse> accountsTableResponses) {
        this.accountsTableResponses = accountsTableResponses;
    }

    public void addToAccountsTableResponses(AccountsTableResponse accountsTableResponse) {
        this.accountsTableResponses.add(accountsTableResponse);
    }
}
