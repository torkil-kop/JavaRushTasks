package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Date;
import java.util.List;

public class VideoSelectedEventDataRow implements EventDataRow{
  private List<Advertisement> optimalVideoSet;

  public long getAmount() {
    return amount;
  }

  private long amount;
  private int totalDuration;
  private Date currentDate = new Date();

  public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
    this.optimalVideoSet = optimalVideoSet;
    this.amount = amount;
    this.totalDuration = totalDuration;
  }

  @Override
  public EventType getType() {
    return EventType.SELECTED_VIDEOS;
  }

  @Override
  public Date getDate() {
    return currentDate;
  }

  @Override
  public int getTime() {
    return totalDuration;
  }
}
