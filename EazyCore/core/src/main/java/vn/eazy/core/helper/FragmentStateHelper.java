package vn.eazy.core.helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import vn.eazy.core.R;
import vn.eazy.core.base.fragment.BaseFragment;

/**
 * Created by Liam Vo on 3/3/17.
 */

public class FragmentStateHelper implements OnFragmentStateAction {
    private FragmentManager fragmentManager;
    private int idContent = R.id.fragment_content;
    private int stackSelected = -1;
    private int tagCount;
    private List<Stack<BaseFragment>> stacksFragment;
    private BaseFragment[] rootFragments;

    public FragmentStateHelper(FragmentManager fragmentManager, int idContent) {
        this.fragmentManager = fragmentManager;
        this.idContent = idContent;
        stacksFragment = new ArrayList<>();
    }

    @Override
    public void setStacksRootFragment(BaseFragment... fragments) {
        rootFragments = new BaseFragment[fragments.length];
        for (int index = 0; index < fragments.length; index++) {
            stacksFragment.add(new Stack<BaseFragment>());
        }
        rootFragments = fragments;
    }

    @Override
    public void changeRootFragment(BaseFragment fragments, int stackId) {
        clearStack(stackId, true);
        rootFragments[stackId] = fragments;
        if (stackId == stackSelected) {
            refreshStack(stackId);
        }
    }


    @Override
    public boolean isRootFragment() {
        if (stacksFragment.get(stackSelected).size() <= 1) {
            return true;
        }
        return false;
    }

    @Override
    public void pushFragment(BaseFragment fragment) {
        beginTrans().add(idContent, fragment, generateTag(fragment)).commit();
        beginTrans().detach(getFragByTag(stacksFragment.get(stackSelected).peek().getTag())).commit();
        stacksFragment.get(stackSelected).push(fragment);
    }

    @Override
    public void popFragment(int numberPop) {
        if (numberPop >= stacksFragment.get(stackSelected).size()) {
            throw new StringIndexOutOfBoundsException("Number pop out of stack size");
        }
        for (int index = 0; index < numberPop; index++) {
            beginTrans().remove(getFragByTag(stacksFragment.get(stackSelected).pop().getTag())).
                    commit();
        }
        beginTrans().attach(getFragByTag(stacksFragment.get(stackSelected).peek().getTag())).
                commit();
    }

    @Override
    public void showStack(int stackId) {
        if (stackId == stackSelected) {
            return;
        }
        if (stacksFragment.get(stackId).size() == 0) {
            refreshStack(stackId);
        } else {
            beginTrans().attach(getFragByTag(stacksFragment.get(stackId).peek().getTag())).
                    commit();
        }
        if (stackSelected != -1) {
            beginTrans().detach(getFragByTag(stacksFragment.get(stackSelected).peek().getTag())).
                    commit();
        }
        stackSelected = stackId;
    }


    @Override
    public void replaceFragment(BaseFragment fragment) {

    }

    @Override
    public void clearStack(int stackId, boolean notKeepRoot) {
        Stack<BaseFragment> stackFragment = stacksFragment.get(stackId);
        int minIndex = 1;
        if (notKeepRoot) {
            minIndex = 0;
        }
        while (stackFragment.size() > minIndex) {
            beginTrans().remove(getFragByTag(stackFragment.pop().getTag()));
        }
    }


    @Override
    public void clearAllStacks(boolean notKeepRoot) {
        for (Stack<BaseFragment> stack : stacksFragment) {
            clearStack(stacksFragment.indexOf(stack), notKeepRoot);
        }
    }

    private String generateTag(BaseFragment fragment) {
        return fragment.getClass().getName() + ++tagCount;
    }

    private Fragment getFragByTag(String tab) {
        return fragmentManager.findFragmentByTag(tab);
    }


    private FragmentTransaction beginTrans() {
        return fragmentManager.beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
    }

    private void refreshStack(int stackId) {
        stacksFragment.get(stackId).push(rootFragments[stackId]);
        beginTrans().add(
                idContent,
                stacksFragment.get(stackId).peek(),
                generateTag(stacksFragment.get(stackId).peek())).
                commit();
    }
}
