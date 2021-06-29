package com.google.firebase.codelab.friendlychat

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver

class MyScrollToBottomObserver(
    private val recycler: RecyclerView,
    private val adapter: FriendlyMessageAdapter,
    private val manager: LinearLayoutManager
) : AdapterDataObserver() {
    // 當數據原發生變更時，及時響應介面變化
    // positionStrat 和
    // 列表從positionStart位置到itemCount數量的列表項批量新增資料時呼叫，伴有動畫效果
//    * @param positionStart 被插入的首个元素位置 ;
//    * @param itemCount 被插入元素个数 ;
    override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
        super.onItemRangeInserted(positionStart, itemCount)

        val count = adapter.itemCount
        val lastVisiblePosition = manager.findLastCompletelyVisibleItemPosition()
//        findFirstCompletelyVisibleItemPosition();//獲取第一個完全可見的Item位置
//        findFirstVisibleItemPosition();//獲取第一個可見Item的位置
//        findLastCompletelyVisibleItemPosition();//獲取最後一個完全可見的Item位置
//        findLastVisibleItemPosition();//獲取最後一個可見Item的位置
        // If the recycler view is initially being loaded or the
        // user is at the bottom of the list, scroll to the bottom
        // of the list to show the newly added message.
        // 如果回收器视图最初正在加载或
        // 用户在列表底部，滚动到底部
        // 在列表中显示新添加的消息。
        Log.d("AAAA", "lastVisiblePosition: "+lastVisiblePosition)
        Log.d("AAAA", "positionStart: "+positionStart)
        Log.d("AAAA", "itemCount: "+itemCount)
        Log.d("AAAA", "count: "+count)


        // 當新的訊息出現，會自動滑到下面。
        val loading = lastVisiblePosition == -1
        // 假設現在 adapter.count 會有 23 個 item，那麼被插入的 positionStart index 會是 22
        // 最後一個可被完整檢視的 item 會等於 被插入的 position -1
        // 因此最後的 lastVisiblePosition index = 21; 被插入的 positionStart index = 22，因此 21 == 22-1
        val atBottom = positionStart >= count - 1 && lastVisiblePosition == positionStart - 1
        // 如果都成立的話，就會滑動到被插入的 index 下方
        if (loading || atBottom) {
            recycler.scrollToPosition(positionStart)
        }
    }
}
