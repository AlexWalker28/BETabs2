package com.example.alexwalker.betabs2;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Lesson
{
  private Boolean isOdd;
  private String objectId;
  private Integer number;
  private Integer order;
  private String ownerId;
  private Integer dayOfWeek;
  private Integer year;
  private Boolean isLecture;
  private Double serialVersionUID;
  private java.util.Date updated;
  private java.util.Date created;
  private Subject lessonName;
  private Address lessonAddress;
  public Boolean getIsOdd()
  {
    return isOdd;
  }

  public void setIsOdd( Boolean isOdd )
  {
    this.isOdd = isOdd;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public Integer getNumber()
  {
    return number;
  }

  public void setNumber( Integer number )
  {
    this.number = number;
  }

  public Integer getOrder()
  {
    return order;
  }

  public void setOrder( Integer order )
  {
    this.order = order;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public Integer getDayOfWeek()
  {
    return dayOfWeek;
  }

  public void setDayOfWeek( Integer dayOfWeek )
  {
    this.dayOfWeek = dayOfWeek;
  }

  public Integer getYear()
  {
    return year;
  }

  public void setYear( Integer year )
  {
    this.year = year;
  }

  public Boolean getIsLecture()
  {
    return isLecture;
  }

  public void setIsLecture( Boolean isLecture )
  {
    this.isLecture = isLecture;
  }

  public Double getSerialVersionUID()
  {
    return serialVersionUID;
  }

  public void setSerialVersionUID( Double serialVersionUID )
  {
    this.serialVersionUID = serialVersionUID;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public Subject getLessonName()
  {
    return lessonName;
  }

  public void setLessonName( Subject lessonName )
  {
    this.lessonName = lessonName;
  }

  public Address getLessonAddress()
  {
    return lessonAddress;
  }

  public void setLessonAddress( Address lessonAddress )
  {
    this.lessonAddress = lessonAddress;
  }

                                                    
  public Lesson save()
  {
    return Backendless.Data.of( Lesson.class ).save( this );
  }

  public Future<Lesson> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Lesson> future = new Future<Lesson>();
      Backendless.Data.of( Lesson.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Lesson> callback )
  {
    Backendless.Data.of( Lesson.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Lesson.class ).remove( this );
  }

  public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of( Lesson.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Lesson.class ).remove( this, callback );
  }

  public static Lesson findById( String id )
  {
    return Backendless.Data.of( Lesson.class ).findById( id );
  }

  public static Future<Lesson> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Lesson> future = new Future<Lesson>();
      Backendless.Data.of( Lesson.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Lesson> callback )
  {
    Backendless.Data.of( Lesson.class ).findById( id, callback );
  }

  public static Lesson findFirst()
  {
    return Backendless.Data.of( Lesson.class ).findFirst();
  }

  public static Future<Lesson> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Lesson> future = new Future<Lesson>();
      Backendless.Data.of( Lesson.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Lesson> callback )
  {
    Backendless.Data.of( Lesson.class ).findFirst( callback );
  }

  public static Lesson findLast()
  {
    return Backendless.Data.of( Lesson.class ).findLast();
  }

  public static Future<Lesson> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Lesson> future = new Future<Lesson>();
      Backendless.Data.of( Lesson.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Lesson> callback )
  {
    Backendless.Data.of( Lesson.class ).findLast( callback );
  }

  public static BackendlessCollection<Lesson> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Lesson.class ).find( query );
  }

  public static Future<BackendlessCollection<Lesson>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Lesson>> future = new Future<BackendlessCollection<Lesson>>();
      Backendless.Data.of( Lesson.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Lesson>> callback )
  {
    Backendless.Data.of( Lesson.class ).find( query, callback );
  }
}