package com.backendless.tabs.data;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Department
{
  private String ownerId;
  private String objectId;
  private java.util.Date created;
  private java.util.Date updated;
  private String address;
  private String name;
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

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress( String address )
  {
    this.address = address;
  }

  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

                                                    
  public Department save()
  {
    return Backendless.Data.of( Department.class ).save( this );
  }

  public Future<Department> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Department> future = new Future<Department>();
      Backendless.Data.of( Department.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Department> callback )
  {
    Backendless.Data.of( Department.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Department.class ).remove( this );
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
      Backendless.Data.of( Department.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Department.class ).remove( this, callback );
  }

  public static Department findById( String id )
  {
    return Backendless.Data.of( Department.class ).findById( id );
  }

  public static Future<Department> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Department> future = new Future<Department>();
      Backendless.Data.of( Department.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Department> callback )
  {
    Backendless.Data.of( Department.class ).findById( id, callback );
  }

  public static Department findFirst()
  {
    return Backendless.Data.of( Department.class ).findFirst();
  }

  public static Future<Department> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Department> future = new Future<Department>();
      Backendless.Data.of( Department.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Department> callback )
  {
    Backendless.Data.of( Department.class ).findFirst( callback );
  }

  public static Department findLast()
  {
    return Backendless.Data.of( Department.class ).findLast();
  }

  public static Future<Department> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Department> future = new Future<Department>();
      Backendless.Data.of( Department.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Department> callback )
  {
    Backendless.Data.of( Department.class ).findLast( callback );
  }

  public static BackendlessCollection<Department> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Department.class ).find( query );
  }

  public static Future<BackendlessCollection<Department>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Department>> future = new Future<BackendlessCollection<Department>>();
      Backendless.Data.of( Department.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Department>> callback )
  {
    Backendless.Data.of( Department.class ).find( query, callback );
  }
}