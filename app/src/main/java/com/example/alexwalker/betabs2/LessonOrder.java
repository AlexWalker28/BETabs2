package com.example.alexwalker.betabs2;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class LessonOrder
{
  private java.util.Date updated;
  private Integer order;
  private String ownerId;
  private String objectId;
  private java.util.Date created;
  public java.util.Date getUpdated()
  {
    return updated;
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

  public String getObjectId()
  {
    return objectId;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

                                                    
  public LessonOrder save()
  {
    return Backendless.Data.of( LessonOrder.class ).save( this );
  }

  public Future<LessonOrder> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<LessonOrder> future = new Future<LessonOrder>();
      Backendless.Data.of( LessonOrder.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<LessonOrder> callback )
  {
    Backendless.Data.of( LessonOrder.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( LessonOrder.class ).remove( this );
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
      Backendless.Data.of( LessonOrder.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( LessonOrder.class ).remove( this, callback );
  }

  public static LessonOrder findById( String id )
  {
    return Backendless.Data.of( LessonOrder.class ).findById( id );
  }

  public static Future<LessonOrder> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<LessonOrder> future = new Future<LessonOrder>();
      Backendless.Data.of( LessonOrder.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<LessonOrder> callback )
  {
    Backendless.Data.of( LessonOrder.class ).findById( id, callback );
  }

  public static LessonOrder findFirst()
  {
    return Backendless.Data.of( LessonOrder.class ).findFirst();
  }

  public static Future<LessonOrder> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<LessonOrder> future = new Future<LessonOrder>();
      Backendless.Data.of( LessonOrder.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<LessonOrder> callback )
  {
    Backendless.Data.of( LessonOrder.class ).findFirst( callback );
  }

  public static LessonOrder findLast()
  {
    return Backendless.Data.of( LessonOrder.class ).findLast();
  }

  public static Future<LessonOrder> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<LessonOrder> future = new Future<LessonOrder>();
      Backendless.Data.of( LessonOrder.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<LessonOrder> callback )
  {
    Backendless.Data.of( LessonOrder.class ).findLast( callback );
  }

  public static BackendlessCollection<LessonOrder> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( LessonOrder.class ).find( query );
  }

  public static Future<BackendlessCollection<LessonOrder>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<LessonOrder>> future = new Future<BackendlessCollection<LessonOrder>>();
      Backendless.Data.of( LessonOrder.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<LessonOrder>> callback )
  {
    Backendless.Data.of( LessonOrder.class ).find( query, callback );
  }
}