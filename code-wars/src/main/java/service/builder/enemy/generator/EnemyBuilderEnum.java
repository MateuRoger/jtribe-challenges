package service.builder.enemy.generator;

import entity.Coordinate;
import entity.WarMap;

public enum EnemyBuilderEnum {
  UP {
    @Override
    public Coordinate build(final Coordinate initialCoordinate, final int distance,
        final WarMap warMap) {
      return new Coordinate()
          .setCoordinateX(initialCoordinate.getCoordinateX())
          .setCoordinateY(
              (initialCoordinate.getCoordinateY() + distance)
                  % warMap.getMaxCoord().getCoordinateY());
    }

    @Override
    public EnemyBuilderEnum next() {
      return UP_RIGHT;
    }
  },
  UP_RIGHT {
    @Override
    public Coordinate build(final Coordinate initialCoordinate, final int distance,
        final WarMap warMap) {
      return new Coordinate()
          .setCoordinateX(
              (initialCoordinate.getCoordinateX() + distance / 2)
                  % warMap.getMaxCoord().getCoordinateX())
          .setCoordinateY(
              (initialCoordinate.getCoordinateY() + distance / 2)
                  % warMap.getMaxCoord().getCoordinateY());
    }

    @Override
    public EnemyBuilderEnum next() {
      return RIGHT;
    }
  },
  RIGHT {
    @Override
    public Coordinate build(final Coordinate initialCoordinate, final int distance,
        final WarMap warMap) {
      return new Coordinate()
          .setCoordinateX(
              (initialCoordinate.getCoordinateX() + distance)
                  % warMap.getMaxCoord().getCoordinateX())
          .setCoordinateY(initialCoordinate.getCoordinateY());
    }

    @Override
    public EnemyBuilderEnum next() {
      return RIGHT_DOWN;
    }
  },
  RIGHT_DOWN {
    @Override
    public Coordinate build(final Coordinate initialCoordinate, final int distance,
        final WarMap warMap) {
      return new Coordinate()
          .setCoordinateX(
              (initialCoordinate.getCoordinateX() + distance / 2)
                  % warMap.getMaxCoord().getCoordinateX())
          .setCoordinateY(
              (initialCoordinate.getCoordinateY() - distance / 2)
                  % warMap.getMaxCoord().getCoordinateY());
    }

    @Override
    public EnemyBuilderEnum next() {
      return DOWN;
    }
  },
  DOWN {
    @Override
    public Coordinate build(final Coordinate initialCoordinate, final int distance,
        final WarMap warMap) {
      return new Coordinate()
          .setCoordinateX(initialCoordinate.getCoordinateX())
          .setCoordinateY(
              (initialCoordinate.getCoordinateY() - distance)
                  % warMap.getMaxCoord().getCoordinateY());
    }

    @Override
    public EnemyBuilderEnum next() {
      return DOWN_LEFT;
    }
  },
  DOWN_LEFT {
    @Override
    public Coordinate build(final Coordinate initialCoordinate, final int distance,
        final WarMap warMap) {
      return new Coordinate()
          .setCoordinateX(
              (initialCoordinate.getCoordinateX() - distance / 2)
                  % warMap.getMaxCoord().getCoordinateX())
          .setCoordinateY(
              (initialCoordinate.getCoordinateY() - distance / 2)
                  % warMap.getMaxCoord().getCoordinateY());
    }

    @Override
    public EnemyBuilderEnum next() {
      return LEFT;
    }
  },
  LEFT {
    @Override
    public Coordinate build(final Coordinate initialCoordinate, final int distance,
        final WarMap warMap) {
      return new Coordinate()
          .setCoordinateX(
              (initialCoordinate.getCoordinateX() - distance)
                  % warMap.getMaxCoord().getCoordinateX())
          .setCoordinateY(initialCoordinate.getCoordinateY());
    }

    @Override
    public EnemyBuilderEnum next() {
      return LEFT_UP;
    }
  },
  LEFT_UP {
    @Override
    public Coordinate build(final Coordinate initialCoordinate, final int distance,
        final WarMap warMap) {
      return new Coordinate()
          .setCoordinateX(
              (initialCoordinate.getCoordinateX() - distance / 2)
                  % warMap.getMaxCoord().getCoordinateX())
          .setCoordinateY(
              (initialCoordinate.getCoordinateY() + distance / 2)
                  % warMap.getMaxCoord().getCoordinateY());
    }

    @Override
    public EnemyBuilderEnum next() {
      return UP;
    }
  };

  public abstract Coordinate build(final Coordinate initialCoordinate, final int distance,
      final WarMap warMap);

  public abstract EnemyBuilderEnum next();
}