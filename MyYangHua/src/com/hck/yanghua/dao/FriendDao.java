package com.hck.yanghua.dao;

import java.util.List;

import com.hck.yanghua.bean.Friend;



public interface FriendDao {
  public boolean addFriends(Friend friend);
  public List<Friend> getFriends(long uid);
  public boolean deleteFriend(String msgId);
}
